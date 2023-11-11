package com.proyecto.integrador.hotel.libertador.models.service;

import java.util.List;

import com.proyecto.integrador.hotel.libertador.models.entity.Usuario;

public interface IUsuarioService {
	public List<Usuario> findAll();
	
	public Usuario findById(Long id);
	
	public Usuario save(Usuario usuario);
	
	public void delete(Long id);
	
}
