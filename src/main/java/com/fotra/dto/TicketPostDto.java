package com.fotra.dto;

public class TicketPostDto {

	private String lang;

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public TicketPostDto(String lang) {
		super();
		this.lang = lang;
	}
	
	public TicketPostDto() {
	}
}
