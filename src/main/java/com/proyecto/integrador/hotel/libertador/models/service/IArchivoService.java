package com.proyecto.integrador.hotel.libertador.models.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IArchivoService {
	
	//public Resource cargar(String nombre) throws MalformedURLException;
	public String subir(MultipartFile archivo) throws IOException;
	//public boolean eliminar(String nombreFoto);
	public Path getPath(String nombre);
}
