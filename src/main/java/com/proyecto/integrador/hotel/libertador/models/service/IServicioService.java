package com.proyecto.integrador.hotel.libertador.models.service;

import java.util.List;

import com.proyecto.integrador.hotel.libertador.models.entity.Servicio;

public interface IServicioService {
	public List<Servicio> findAll();
	
	public Servicio findById(Long id);
	
	public Servicio save(Servicio servicio);
	
	public void delete(Long id);
}
