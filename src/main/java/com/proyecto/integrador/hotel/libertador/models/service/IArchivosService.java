package com.proyecto.integrador.hotel.libertador.models.service;

import org.springframework.web.multipart.MultipartFile;

import com.proyecto.integrador.hotel.libertador.models.entity.Archivos;

public interface IArchivosService {

	public Archivos save(Archivos archivo);
	public void delete(Long id);
	public Archivos findByNombre(String nombre);
}
