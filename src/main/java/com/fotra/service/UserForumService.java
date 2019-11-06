package com.fotra.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fotra.database.entities.UserForum;
import com.fotra.database.repositories.UserForumRepository;

@Service
@Transactional
public class UserForumService {

	private static Logger logger = Logger.getLogger(UserForumService.class);

	@Autowired
	private EmailService emailService;

	@Autowired
	UserForumRepository userForumRepository;

	@Autowired
	BCryptPasswordEncoder encoder;

	public boolean saveUserForum(String username, String login, String password, String email) {

		UserForum flag = null;
		flag = userForumRepository.findByLoginOrEmailOrName(login, email, username);

		logger.info(flag);

		if (flag == null) {
			password = encoder.encode(password);
			UserForum saveFlag = userForumRepository
					.save(new UserForum(username, login, email, password, "USER", new Date(), 0));
			logger.info(saveFlag);

			boolean mail = emailService.sendSimpleMessage(email, "FoTra!", "Thanks for registration!");
			if (mail) {
				return true;
			} else {
				return false;
			}
		} else
			return false;
	}

	public UserForum getUserforum(String login, String password) {
		UserForum userForum = null;
		userForum = userForumRepository.findByLoginAndPassword(login, password);
		logger.info(encoder.matches(password, userForum.getPassword()));
		return userForum;
	}

	public UserForum getLoginUser(String login) {
		UserForum userForum = null;
		userForum = userForumRepository.findByLogin(login);
		return userForum;
	}
	
	public void setPasswordByEmail(String password, String email) {
		password = encoder.encode(password);
		userForumRepository.updatePasswordByEmail(password, email);
	}
}
