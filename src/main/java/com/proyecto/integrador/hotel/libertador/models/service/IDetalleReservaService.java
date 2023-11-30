package com.proyecto.integrador.hotel.libertador.models.service;

import java.util.List;

import com.proyecto.integrador.hotel.libertador.models.entity.DetalleReserva;

public interface IDetalleReservaService {
	public List<DetalleReserva> findAll();
	public DetalleReserva findById(Long id);
	public DetalleReserva save(DetalleReserva detalle);
	public void delete(Long id);
}