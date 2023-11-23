package com.proyecto.integrador.hotel.libertador.models.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	@Override
	@Transactional(readOnly = true)
	public Page<Servicio> findAll(Pageable pageable) {
		return servicioDao.findAll(pageable);
	}
	
	@Override
    @Transactional
    public void cambiarEstadoServicio(long id) throws EntityNotFoundException {
        Servicio servicio = servicioDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException ("El servicio con ID " + id + " no existe."));

        if ("Activo".equals(servicio.getEstado())) {
            servicio.setEstado("Desactivado");
            servicio.setFechaBaja(new Date()); 
        } else {
            servicio.setEstado("Activo");
            servicio.setFechaBaja(null); 
        }

        servicioDao.save(servicio);
    }
	
}
