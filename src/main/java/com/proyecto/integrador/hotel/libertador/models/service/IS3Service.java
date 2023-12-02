package com.proyecto.integrador.hotel.libertador.models.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.services.s3.S3Client;

public interface IS3Service {
	
	String uploadFile (MultipartFile file) throws IOException;
	String downloadFile(String fileName) throws IOException;
	String deleteFile(String fileName) throws IOException;
}
