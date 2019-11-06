package com.fotra.service;

public interface EmailService {

	public boolean sendSimpleMessage(String to, String subject, String text);
	
}
