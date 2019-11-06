package com.fotra.dto;

import com.fotra.database.entities.UserForum;

public class AdminDto {
	private Integer id;
    private String name;
    private String login;
    private String role;
    private String email;

    public UserForum toUser(){
    	UserForum user = new UserForum();
        user.setId_user(id);
        user.setName(name);
        user.setLogin(login);
        user.setRole(role);
        user.setEmail(email);

        return user;
    }

    public static UserDto fromUser(UserForum user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId_user());
        userDto.setName(user.getName());
        userDto.setLogin(user.getLogin());
        userDto.setRole(user.getRole());
        userDto.setEmail(user.getEmail());

        return userDto;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
