package com.proyecto.integrador.hotel.libertador.models.service;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.neptunedata.model.S3Exception;
import software.amazon.awssdk.services.s3.S3Client;

@Service
public class S3ServiceImpl implements IS3Service{
	
	private final S3Client s3Client;
	
	@Value("${upload.s3.localPath}")
	private String localPath;
	
	
	@Autowired
	public S3ServiceImpl(S3Client s3Client){
		this.s3Client=s3Client;
	}
	
	public String uploadFile (MultipartFile file) throws IOException {
		try {
			String fileName=file.getOriginalFilename();
			
			PutObjectRequest putObjectRequest = PutObjectRequest.builder()
				    .bucket("hotel-libetador")
				    .key(fileName)
				    .build();
			s3Client.putObject(putObjectRequest, RequestBody.fromBytes(file.getBytes()));
			
			
			return fileName;
			
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}
	}
	
	public String downloadFile(String fileName) throws IOException {
		if(!doesObjectExists(fileName)) {
			return "El archivo introducido no existe";
		}
		GetObjectRequest request=GetObjectRequest.builder()
				.bucket("hotel-libetador")
			    .key(fileName)
			    .build();
		
		ResponseInputStream<GetObjectResponse> result=s3Client.getObject(request);
		
		try (FileOutputStream fos=new FileOutputStream(localPath + fileName)){
			byte[] read_buf=new byte[1024];
			int read_len=0;
			while((read_len=result.read(read_buf))>0) {
				fos.write(read_buf,0,read_len);
			}
			
		} catch (IOException e) {
			throw new IOException(e.getMessage());
			
		}
		return "Archivo descargado correctamente";
	}
	
	public String deleteFile(String fileName) throws IOException {
		if(!doesObjectExists(fileName)) {
			return "El archivo ingresado no existe";
		}
		
		try {
			DeleteObjectRequest deleteObjectRequest= DeleteObjectRequest.builder()
					.bucket("hotel-libetador")
				    .key(fileName)
				    .build();
			s3Client.deleteObject(deleteObjectRequest);
			return "Archivo borrado correctamente";
			
		} catch (S3Exception e) {
			throw new IOException(e.getMessage());
		}
	}
	
	
	
	private boolean doesObjectExists(String objectKey) {
		try {
			HeadObjectRequest headObjectRequest= HeadObjectRequest.builder()
					.bucket("hotel-libetador")
				    .key(objectKey)
				    .build();
			s3Client.headObject(headObjectRequest);
			
			return true;
			
		} catch (S3Exception e) {
			if(e.statusCode() == 404) {
				return false;
			}
		}
		return true;
	}
	


}
