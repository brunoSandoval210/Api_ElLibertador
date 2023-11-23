package com.proyecto.integrador.hotel.libertador.models.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.integrador.hotel.libertador.models.dao.ICategoriaDao;
import com.proyecto.integrador.hotel.libertador.models.dao.IServicioDao;
import com.proyecto.integrador.hotel.libertador.models.entity.Categoria;
import com.proyecto.integrador.hotel.libertador.models.entity.Servicio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriaServiceImpl implements ICategoriaService{
	
	@Autowired
	private ICategoriaDao categoriaDao;
	
	@Autowired
	private IServicioDao servicioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Categoria> findAll() {
		return (List<Categoria>) categoriaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Categoria findById(Long id) {
		return categoriaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Categoria save(Categoria categoria) {
		return categoriaDao.save(categoria);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		categoriaDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Categoria> findAll(Pageable pageable) {
		return categoriaDao.findAll(pageable);
	}
	
	@Override
    @Transactional
    public void cambiarEstadoCategoria(long id) throws EntityNotFoundException {
        Categoria categoria = categoriaDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException ("La categoria con ID " + id + " no existe."));

        if ("Activo".equals(categoria.getEstado())) {
        	categoria.setEstado("Desactivado");
        	categoria.setFechaBaja(new Date()); 
        } else {
        	categoria.setEstado("Activo");
        	categoria.setFechaBaja(null); 
        }

        categoriaDao.save(categoria);
    }
	

}
