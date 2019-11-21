package com.fotra.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fotra.database.entities.UserForum;
import com.fotra.dto.AuthenticationRequestDto;
import com.fotra.security.jwt.JwtTokenProvider;
import com.fotra.service.UserForumService;

@RestController
@RequestMapping(value = "/perm/an/auth/")
public class AuthController {

	private static Logger logger = Logger.getLogger(AuthController.class);
	
    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserForumService userService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserForumService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            String username = requestDto.getUsername();
            logger.info("USERNAME --- " + username + " PASSWORD --- " + requestDto.getPassword());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            UserForum user = userService.getLoginUser(username);
            logger.info("USER --- " + user);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, user.getRole());

            Map<Object, Object> response = new HashMap<>();
            response.put("name", user.getName());
            response.put("login", username);
            response.put("reg_data", user.getReg_data());
            response.put("karma", user.getKarma());
            response.put("token", token);
            
            logger.info("USERNAME --- " + username + " TOKEN --- " + token);
            
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password ");
        }
    }
}