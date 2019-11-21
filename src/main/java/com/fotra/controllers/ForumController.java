package com.fotra.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fotra.database.repositories.PostForumRepository.PostFrameReqDtoRepo;
import com.fotra.dto.PostDto;
import com.fotra.service.PostForumSevice;

@RestController
@RequestMapping(value = "/v/auth/forum/")
public class ForumController {

	@Autowired
	PostForumSevice postForumSevice;
	
	@ResponseBody
    @GetMapping("allposts")
    public Iterable<PostFrameReqDtoRepo> getPosts() {
        return postForumSevice.getPosts();
    }
	
    @PostMapping("addpost")
    public ResponseEntity addPost(@RequestBody PostDto postDto) {
    	
    	if (postForumSevice.addPostForum(postDto.getUsername(), 
    			postDto.getHead(), 
    			postDto.getBody(), 
    			new Date(), postDto.getLangID())) {
    		
    		 Map<Object, Object> response = new HashMap<>();
             response.put("status", HttpStatus.OK);
    		
    		return ResponseEntity.ok(response);
    	}
    	else {
    		Map<Object, Object> response = new HashMap<>();
            response.put("status", HttpStatus.BAD_REQUEST);
    		return ResponseEntity.badRequest().body(response);
    	}
    }

}
