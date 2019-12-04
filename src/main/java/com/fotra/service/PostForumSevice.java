package com.fotra.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fotra.database.entities.PostFrame;
import com.fotra.database.entities.Topic;
import com.fotra.database.entities.UserForum;
import com.fotra.database.repositories.PostForumRepository;
import com.fotra.database.repositories.PostForumRepository.PostFrameReqDtoRepo;
import com.fotra.database.repositories.TopicRepository;
import com.fotra.database.repositories.UserForumRepository;

@Service
public class PostForumSevice {

	private static Logger logger = Logger.getLogger(PostForumSevice.class);
	
	@Autowired
	UserForumRepository UserForumRepo;
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	PostForumRepository postForumRepository;
	
	public boolean addPostForum(String username, String head, String body, Date date, String langID) {
		logger.info("IN addPostForum METHOD");
		Topic topic = null;
		UserForum userForum = null;
		topic = topicRepository.findById(langID).orElse(null);
		logger.info(topic);
		
		if (topic != null) {
			
			userForum = UserForumRepo.findByLogin(username);			
			if (userForum != null) {
				PostFrame postFrame = new PostFrame(userForum.getId_user(), head, body, date, 0, 0, true, topic.getId_topic());
				postForumRepository.save(postFrame);
				return true;
			}
			
			return false;
		}
		
		return false;
	}
	
	public Iterable<PostFrameReqDtoRepo> getPosts() {
		Iterable<PostFrameReqDtoRepo> postFrame = postForumRepository.findAllPostsWithUser();
		return postFrame;
	}
	
	public Iterable<PostFrameReqDtoRepo> getPostsTicket(String lang) {
		Iterable<PostFrameReqDtoRepo> postFrame = postForumRepository.findAllPostsWithTopic(lang);
		return postFrame;
	}
	
	public Iterable<PostFrameReqDtoRepo> getPostsUser(Integer id) {
		Iterable<PostFrameReqDtoRepo> postFrame = postForumRepository.findAllPostsWithUser(id);
		return postFrame;
	}
}
