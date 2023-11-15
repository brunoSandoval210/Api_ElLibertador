package com.proyecto.integrador.hotel.libertador.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.integrador.hotel.libertador.models.entity.Categoria;

public interface ICategoriaDao extends JpaRepository<Categoria, Long>{
	/*@Query("select u from Categoria u where u.nombre=?1")
	public Categoria findByNombre(String nombre);*/
}
