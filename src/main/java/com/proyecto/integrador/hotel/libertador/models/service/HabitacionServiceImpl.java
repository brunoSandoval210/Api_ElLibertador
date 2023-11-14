package com.proyecto.integrador.hotel.libertador.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.integrador.hotel.libertador.models.dao.IHabitacionDao;
import com.proyecto.integrador.hotel.libertador.models.entity.Habitacion;

@Service
public class HabitacionServiceImpl implements IHabitacionService{
	@Autowired
	private IHabitacionDao habitacionDao;

	@Override
	@Transactional(readOnly =true)
	public List<Habitacion> findAll() {
		return (List<Habitacion>)habitacionDao.findAll();
	}

	@Override
	@Transactional(readOnly =true)
	public Page<Habitacion> findAll(Pageable pageable) {
		return habitacionDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Habitacion findById(Long id) {
		return habitacionDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Habitacion save(Habitacion habitacion) {
		return habitacionDao.save(habitacion);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		habitacionDao.deleteById(id);
	}

}
