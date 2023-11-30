package com.proyecto.integrador.hotel.libertador.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyecto.integrador.hotel.libertador.models.entity.Categoria;

import jakarta.persistence.EntityNotFoundException;

public interface ICategoriaService {
	public List<Categoria> findAll();
	
	public Page<Categoria> findAll(Pageable pageable);
	
	public Categoria findById(Long id);
	
	public Categoria save(Categoria categoria);
	
	public void delete(Long id);
	
	public void cambiarEstadoCategoria(long id) throws EntityNotFoundException;
	
	public Categoria findMaxIdCategoria();
	
	public void actualizarServiciosDeCategoria(Long idCategoria, List<Long> idsServicios);
	
	public List<Long> obtenerIdsServiciosPorCategoria(Long idCategoria);
}
