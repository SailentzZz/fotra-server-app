package com.fotra.security;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fotra.database.entities.UserForum;
import com.fotra.service.UserForumService;

@Service
public class JwtUserForumService implements UserDetailsService {

	private static Logger logger = Logger.getLogger(JwtUserForumService.class);
	
	@Autowired
	UserForumService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserForum user = null;
        Set<GrantedAuthority> grantedAuthorities = null;
        try
        {
            user = userService.getLoginUser(username);
            if(user == null)
                throw new UsernameNotFoundException("User " + username  + " not available");

            grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        }
        catch(Exception exp) {
            exp.printStackTrace();
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), grantedAuthorities);
	}

}
