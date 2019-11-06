package com.fotra.security.jwt;

import com.fotra.database.entities.UserForum;

public class JwtUserForumFactory {

	public JwtUserForumFactory() {
	}
	
	public static JwtUserForum create(UserForum user) {
        return new JwtUserForum(
                user.getId_user(),
                user.getName(),
                user.getLogin(),
                user.getEmail(),
                user.getPassword(),
                user.getRole()
        );
    }
}
