package com.proyecto.integrador.hotel.libertador.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.integrador.hotel.libertador.models.dao.IInformesDao;
import com.proyecto.integrador.hotel.libertador.models.entity.Informes;

@Service
public class InformesServiceImpl implements IInformesService{

	@Autowired
	private IInformesDao informesDap;
	
	@Override
	@Transactional(readOnly = true)
	public List<Informes> findAll() {
		return (List<Informes>) informesDap.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Informes> findAll(Pageable pageable) {
		return informesDap.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Informes findById(Long id) {
		return informesDap.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Informes save(Informes informes) {
		return informesDap.save(informes);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		informesDap.deleteById(id);
		
	}
	

}
