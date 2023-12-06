package com.proyecto.integrador.hotel.libertador.models.entity;


import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class EmailFileDTO {
	
	private String [] toUser;
	private String subject;
	private String message;
	private MultipartFile file;
	
	public EmailFileDTO(String[] toUser, String subject, String message, MultipartFile file) {
		this.toUser = toUser;
		this.subject = subject;
		this.message = message;
		this.file = file;
	}
	
	
	public EmailFileDTO() {
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
	public MultipartFile getFile() {
		return file;
	}


	@Override
	public String toString() {
		return "EmailFileDTO [toUser=" + Arrays.toString(toUser) + ", subject=" + subject + ", message=" + message
				+ ", file=" + file + "]";
	}
	
}
