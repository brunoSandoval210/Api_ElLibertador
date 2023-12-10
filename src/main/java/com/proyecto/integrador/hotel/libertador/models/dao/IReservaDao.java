package com.proyecto.integrador.hotel.libertador.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.integrador.hotel.libertador.models.entity.Reserva;

public interface IReservaDao extends JpaRepository<Reserva, Long>{
	List<Reserva> findByUsuario_DNI(int dni);
}
