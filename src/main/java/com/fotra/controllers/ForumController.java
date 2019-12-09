package com.fotra.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fotra.database.entities.Answer;
import com.fotra.database.repositories.AnswerPostRepo;
import com.fotra.dto.AnswerDto;
import com.fotra.service.AnswerService;
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
import com.fotra.dto.TicketPostDto;
import com.fotra.dto.UserDto;
import com.fotra.service.PostForumSevice;

@RestController
@RequestMapping(value = "/v/auth/forum/")
public class ForumController {

    @Autowired
    AnswerService answerService;

	@Autowired
	PostForumSevice postForumSevice;
	
	@ResponseBody
    @GetMapping("allposts")
    public Iterable<PostFrameReqDtoRepo> getPosts() {
        return postForumSevice.getPosts();
    }
	
	@ResponseBody
    @GetMapping("ticketposts")
    public Iterable<PostFrameReqDtoRepo> getPostsTicket(@RequestBody TicketPostDto lang) {
        return postForumSevice.getPostsTicket(lang.getLang());
    }
	
    @ResponseBody
    @GetMapping(value = "userposts")
    public Iterable<PostFrameReqDtoRepo> getUserPosts(@RequestBody UserDto user){
    	return postForumSevice.getPostsUser(user.getId());
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

    @PostMapping("addanswer")
    public ResponseEntity addAnswer(@RequestBody AnswerDto answerDto) {

        if (answerService.addAnswerToPost(new Answer(answerDto.getBody(),
                answerDto.getAutor(), new Date(), 0, 0, false), answerDto.getId_post())) {

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

    @ResponseBody
    @PostMapping("getpostanswer")
    public Iterable<AnswerPostRepo.PostAnswerReqDtoRepo> getAnswerPost(@RequestBody AnswerDto answerDto) {
        return answerService.getAnswerPostFrame(answerDto.getId_post());
    }
}
