package com.fotra.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fotra.database.entities.UserForum;
import com.fotra.service.UserForumService;

@RestController
@RequestMapping(value = "/perm/an/acc/")
public class AccountController {

	private static Logger logger = Logger.getLogger(AccountController.class);
	
    @Autowired
    private UserForumService userForumService;

    @PostMapping("user")
    public ResponseEntity addUser(@RequestBody UserForum user) {
    	String param = user.getName() + " " + user.getLogin() + " " + user.getPassword() + " " + user.getEmail();
    	logger.info(param);
    	Map<Object, Object> response = new HashMap<>();        
        
        if (userForumService.saveUserForum(user.getName(), user.getLogin(), user.getPassword(), user.getEmail())) {
        	response.put("param", param);
	        response.put("status", "OK");
	        
	        logger.info(param);
	        return ResponseEntity.ok(response);
        } else {
        	response.put("param", param);
	        response.put("status", "DENIED");
        	return ResponseEntity.ok(response);
        }       
    }

}
