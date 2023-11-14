package com.proyecto.integrador.hotel.libertador.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.integrador.hotel.libertador.models.entity.Reserva;

public interface IReservaDao extends JpaRepository<Reserva, Long>{

}
