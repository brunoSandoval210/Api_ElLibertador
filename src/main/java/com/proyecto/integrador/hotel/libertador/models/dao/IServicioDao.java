package com.proyecto.integrador.hotel.libertador.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.integrador.hotel.libertador.models.entity.Servicio;


public interface IServicioDao extends JpaRepository<Servicio, Long>{
}
