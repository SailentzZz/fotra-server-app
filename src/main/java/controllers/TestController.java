package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repos.UserForum;
import repos.UserForumRepository;

@RestController
@RequestMapping(value = "/hello")
public class TestController {

	@Autowired
	private UserForumRepository userForumRepository;
	
	@RequestMapping("/")
    public String hello() {
		UserForum userForum = userForumRepository.findById(1).get();
        return userForum.toString();
    }
	
	
}
