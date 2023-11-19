package com.proyecto.integrador.hotel.libertador.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.integrador.hotel.libertador.models.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long>{

	 Usuario findByEmailAndContrasena(String email, String contrasena);
	

}
