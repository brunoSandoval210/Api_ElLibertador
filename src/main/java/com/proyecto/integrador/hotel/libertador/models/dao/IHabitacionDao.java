package com.proyecto.integrador.hotel.libertador.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.integrador.hotel.libertador.models.entity.Habitacion;

public interface IHabitacionDao extends JpaRepository<Habitacion, Long> {

}
