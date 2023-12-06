package com.proyecto.integrador.hotel.libertador.models.entity;

import java.util.Arrays;

public class EmailDTO {
	private String [] toUser;
	private String subject;
	private String message;
	
	
	public EmailDTO() {
	}
	public EmailDTO(String[] toUser, String subject, String message) {
		this.toUser = toUser;
		this.subject = subject;
		this.message = message;
	}
	public String[] getToUser() {
		return toUser;
	}
	public String getSubject() {
		return subject;
	}
	public String getMessage() {
		return message;
	}
	@Override
	public String toString() {
		return "EmailDTO [toUser=" + Arrays.toString(toUser) + ", subject=" + subject + ", message=" + message + "]";
	}
	
		
}
