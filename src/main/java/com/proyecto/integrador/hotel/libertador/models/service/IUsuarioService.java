package com.proyecto.integrador.hotel.libertador.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyecto.integrador.hotel.libertador.models.entity.Usuario;

import jakarta.persistence.EntityNotFoundException;

public interface IUsuarioService {
	public List<Usuario> findAll();
	
	public Page<Usuario> findAll(Pageable pageable);
	
	public Usuario findById(Long id);
	
	public Usuario save(Usuario usuario);
	
	public void delete(Long id);
	
	public void cambiarEstadoUsuario(long id) throws EntityNotFoundException;
	
    public Usuario findByEmailAndContrasena(String email, String contrasena);

}
