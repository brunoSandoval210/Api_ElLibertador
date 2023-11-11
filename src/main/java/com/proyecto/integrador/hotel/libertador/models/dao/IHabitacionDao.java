package com.proyecto.integrador.hotel.libertador.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.integrador.hotel.libertador.models.entity.Habitacion;

public interface IHabitacionDao extends CrudRepository<Habitacion, Long> {

}
