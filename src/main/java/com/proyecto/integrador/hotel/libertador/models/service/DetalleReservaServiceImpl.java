package com.proyecto.integrador.hotel.libertador.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.integrador.hotel.libertador.models.dao.IDetalleReservaDao;
import com.proyecto.integrador.hotel.libertador.models.entity.DetalleReserva;

@Service
public class DetalleReservaServiceImpl implements IDetalleReservaService{

	@Autowired
	IDetalleReservaDao detalleDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<DetalleReserva> findAll() {
		return (List<DetalleReserva>)detalleDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public DetalleReserva findById(Long id) {
		return detalleDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public DetalleReserva save(DetalleReserva detalle) {
		return detalleDao.save(detalle);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		detalleDao.deleteById(id);
	}

}
