package com.proyecto.integrador.hotel.libertador.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.integrador.hotel.libertador.models.dao.IArchivosDao;
import com.proyecto.integrador.hotel.libertador.models.entity.Archivos;
import com.proyecto.integrador.hotel.libertador.models.entity.Categoria;
import com.proyecto.integrador.hotel.libertador.models.entity.Usuario;

@Service
public class IArchivosServiceImpl implements IArchivosService {
	
	@Autowired
    private IArchivosDao archivosDao;

    @Override
    @Transactional
    public Archivos save(Archivos archivo) {
    	Archivos nuevoArchivo = archivosDao.save(archivo);
		return nuevoArchivo;
    }
    
	@Override
	@Transactional
	public void delete(Long id) {
		archivosDao.deleteById(id);	
	}
	
	@Override
    public Archivos findByNombre(String nombre) {
        return archivosDao.findByNombre(nombre);
    }

}
