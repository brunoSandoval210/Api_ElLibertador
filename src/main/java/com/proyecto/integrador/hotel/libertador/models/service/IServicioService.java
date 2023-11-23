package com.proyecto.integrador.hotel.libertador.models.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyecto.integrador.hotel.libertador.models.entity.Servicio;

public interface IServicioService {
	public List<Servicio> findAll();
	
	public Page<Servicio> findAll(Pageable pageable);
	
	public Servicio findById(Long id);
	
	public Servicio save(Servicio servicio);
	
	public void delete(Long id);
	
	public void cambiarEstadoServicio(long id) throws EntityNotFoundException;
	
	
	
}
