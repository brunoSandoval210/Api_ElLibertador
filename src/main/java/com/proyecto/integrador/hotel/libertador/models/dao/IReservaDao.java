package com.proyecto.integrador.hotel.libertador.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.integrador.hotel.libertador.models.entity.Reserva;

public interface IReservaDao extends CrudRepository<Reserva, Long>{

}
