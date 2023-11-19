package com.proyecto.integrador.hotel.libertador.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyecto.integrador.hotel.libertador.models.entity.Habitacion;

import jakarta.persistence.EntityNotFoundException;

public interface IHabitacionService {
public List<Habitacion> findAll();
	
	public Page<Habitacion> findAll(Pageable pageable);
	
	public Habitacion findById(Long id);
	
	public Habitacion save(Habitacion habitacion);
	
	public void delete(Long id);
	
	public void cambiarEstadoHabitacion(long id) throws EntityNotFoundException;

}
