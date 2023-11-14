package com.proyecto.integrador.hotel.libertador.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyecto.integrador.hotel.libertador.models.entity.Reserva;

public interface IReservaService {	
	public List<Reserva> findAll();
	
	public Page<Reserva> findAll(Pageable pageable);
	
	public Reserva findById(Long id);
	
	public Reserva save(Reserva reserva);
	
	public void delete(Long id);
}
