package com.fotra.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fotra.database.entities.PasswordReset;
import com.fotra.database.entities.UserForum;
import com.fotra.database.repositories.PasswordResetRepository;
import com.fotra.database.repositories.UserForumRepository;
import com.fotra.dto.PasswordForgotDto;
import com.fotra.security.jwt.JwtTokenProvider;
import com.fotra.service.EmailService;
import com.fotra.service.UserForumService;


@RestController
@RequestMapping(value = "/perm/an/reset/")
public class UserRestControllerV1 {
	
	private static Logger logger = Logger.getLogger(UserRestControllerV1.class);
	
    private final UserForumService userService;
    private final UserForumRepository userRepo;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordResetRepository passRepo;
    private final EmailService emailService;
    

    @Autowired
    public UserRestControllerV1(UserForumService userService, 
    		JwtTokenProvider jwtTokenProvider, 
    		UserForumRepository userRepo, 
    		PasswordResetRepository passRepo,
    		EmailService emailService) {
    	
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepo = userRepo;
        this.passRepo = passRepo;
        this.emailService = emailService;
    }

    @GetMapping(value = "user")
    public ResponseEntity<String> getUserById(HttpServletRequest req){
//    	String token = jwtTokenProvider.resolveToken(req);
//    	String username = jwtTokenProvider.getUsername(token);

        return new ResponseEntity<>("username", HttpStatus.OK);
    }
    
    @PostMapping(value = "invalid")
    public ResponseEntity invalidPassword(@RequestBody PasswordForgotDto form,
    		HttpServletRequest request) {

    	logger.info(form.getEmail());;
    	UserForum user = null;
        user = userRepo.findByEmail(form.getEmail());
        Map<Object, Object> response = new HashMap<>();
        
        if (user != null) {
	        PasswordReset token = new PasswordReset();
	        token.setToken(UUID.randomUUID().toString());
	        token.setUser(user.getId_user());
	        token.setExpiryDate(30);
	        
	
	        if (emailService.sendSimpleMessage(form.getEmail(), "FoTra!", "Your personal code: " + token.getToken())) {
	        	passRepo.save(token);
	        	response.put("param", form.getEmail());
		        response.put("status", "OK");
	        	return ResponseEntity.ok(response);
	        } else {
	        	return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
	        }
        } else {
        	return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping(value = "check")
    public ResponseEntity resetPassword(@RequestBody PasswordReset form,
    		HttpServletRequest request) {

    	PasswordReset newP = null;
    	newP = passRepo.findByToken(form.getToken()); 
    	Map<Object, Object> response = new HashMap<>();
    	
    	if (newP != null) {
    		
    		long diff = new Date().getTime() - newP.getExpiryDate().getTime();
    		diff = diff / (60 * 1000) % 60;
    		
    		if (diff <= 10) {
    			response.put("param", form.getToken());
		        response.put("status", "OK");
    			return ResponseEntity.ok(response);
    		} else {                 
        		return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        	}
    		
    	} else {                 
    		return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
    	}
    }
    
    @PostMapping(value = "change")
    public ResponseEntity changePassword(@RequestBody UserForum user,
    		HttpServletRequest request) {
    	Map<Object, Object> response = new HashMap<>();
    	
    	userService.setPasswordByEmail(user.getPassword(), user.getEmail());
        response.put("param", user.getPassword());
	    response.put("status", "OK");
	    return ResponseEntity.ok(response);
        
    }
}
