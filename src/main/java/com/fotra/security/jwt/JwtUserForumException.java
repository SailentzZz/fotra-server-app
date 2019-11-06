package com.fotra.security.jwt;

import org.springframework.security.core.AuthenticationException;

public class JwtUserForumException extends AuthenticationException{

	public JwtUserForumException(String msg, Throwable t) {
        super(msg, t);
    }

    public JwtUserForumException(String msg) {
        super(msg);
    }

}
