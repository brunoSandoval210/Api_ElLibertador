package com.proyecto.integrador.hotel.libertador.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.integrador.hotel.libertador.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	
	

}
