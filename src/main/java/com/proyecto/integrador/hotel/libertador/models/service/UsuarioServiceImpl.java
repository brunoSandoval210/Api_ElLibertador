package com.proyecto.integrador.hotel.libertador.models.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.integrador.hotel.libertador.models.dao.IUsuarioDao;
import com.proyecto.integrador.hotel.libertador.models.entity.Usuario;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		usuarioDao.deleteById(id);	
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAll(Pageable pageable) {
		return usuarioDao.findAll(pageable);
	}
	
	@Override
    @Transactional
    public void cambiarEstadoUsuario(long id) throws EntityNotFoundException {
        Usuario usuario = usuarioDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException ("El usuario con ID " + id + " no existe."));

        if ("Activo".equals(usuario.getEstado())) {
        	usuario.setEstado("Desactivado");
        	usuario.setFechaBaja(new Date()); 
        } else {
        	usuario.setEstado("Activo");
        	usuario.setFechaBaja(null); 
        }

        usuarioDao.save(usuario);
    }

	@Override
	@Transactional(readOnly = true)
	public Usuario findByEmailAndContrasena(String email, String contrasena) {
		return usuarioDao.findByEmailAndContrasena(email, contrasena);
	}
}
