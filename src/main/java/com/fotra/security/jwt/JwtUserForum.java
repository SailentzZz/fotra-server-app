package com.fotra.security.jwt;

import java.util.Collection;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUserForum implements UserDetails {

	private final Integer id_user;	
	private final String name;
	private final String login; 
	private final String email;
	private final String password;
	private final String role;
	
	public JwtUserForum(Integer id_user, String name, String login, String email, String password, 
			String role) {
		this.id_user = id_user;
		this.name = name;
		this.login = login;
		this.email = email;
		this.password = password;
		this.role = role;
	}

    @JsonIgnore
    public Integer getId() {
        return id_user;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


}
