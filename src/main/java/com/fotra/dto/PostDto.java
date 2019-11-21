package com.fotra.dto;

public class PostDto {

	private String username;
	private String head;
	private String body;
	private String langID;
	
	public PostDto() {
	}

	public PostDto(String username, String head, String body, String langID) {
		this.username = username;
		this.head = head;
		this.body = body;
		this.langID = langID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getLangID() {
		return langID;
	}

	public void setLangID(String langID) {
		this.langID = langID;
	}
	
}
