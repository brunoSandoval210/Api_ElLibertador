package com.proyecto.integrador.hotel.libertador.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.integrador.hotel.libertador.models.dao.IReservaDao;
import com.proyecto.integrador.hotel.libertador.models.entity.Reserva;

@Service
public class ReservaServiceImpl implements IReservaService{
	
	@Autowired
	private IReservaDao reservaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Reserva> findAll() {
		return (List<Reserva>) reservaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Reserva> findAll(Pageable pageable) {
		return reservaDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Reserva findById(Long id) {
		return reservaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Reserva save(Reserva reserva) {
		return reservaDao.save(reserva);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		reservaDao.deleteById(id);
	}

}