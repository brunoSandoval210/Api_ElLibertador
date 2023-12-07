package com.proyecto.integrador.hotel.libertador.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyecto.integrador.hotel.libertador.models.entity.Informes;

public interface IInformesService {
public List<Informes> findAll();
	
	public Page<Informes> findAll(Pageable pageable);
	
	public Informes findById(Long id);
	
	public Informes save(Informes informes);
	
	public void delete(Long id);
}
