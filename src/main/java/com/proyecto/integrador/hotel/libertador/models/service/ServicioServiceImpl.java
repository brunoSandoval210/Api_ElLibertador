package com.proyecto.integrador.hotel.libertador.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.integrador.hotel.libertador.models.dao.IServicioDao;
import com.proyecto.integrador.hotel.libertador.models.entity.Servicio;

@Service
public class ServicioServiceImpl implements IServicioService{
	@Autowired
	private IServicioDao servicioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Servicio> findAll() {
		return (List<Servicio>) servicioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Servicio findById(Long id) {
		return servicioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Servicio save(Servicio servicio) {
		return servicioDao.save(servicio);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		servicioDao.deleteById(id);
		
	}
}
