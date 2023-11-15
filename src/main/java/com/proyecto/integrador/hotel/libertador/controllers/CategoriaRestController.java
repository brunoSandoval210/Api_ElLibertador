package com.proyecto.integrador.hotel.libertador.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.integrador.hotel.libertador.models.entity.Categoria;
import com.proyecto.integrador.hotel.libertador.models.entity.Servicio;
import com.proyecto.integrador.hotel.libertador.models.service.ICategoriaService;
import com.proyecto.integrador.hotel.libertador.models.service.IServicioService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;



@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class CategoriaRestController {

	@Autowired
	private ICategoriaService categoriaService;
	
	@Autowired IServicioService servicioService;
	
	private final Logger log=LoggerFactory.getLogger(CategoriaRestController.class);
	
	@GetMapping("/categorias")
	public List<Categoria> index() {
		return categoriaService.findAll();
	}

	@GetMapping("/categorias/page/{page}")
	public Page<Categoria> index(@PathVariable Integer page) {
	    Pageable pageable = PageRequest.of(page, 10);
	    return categoriaService.findAll(pageable);
	}
	
	@GetMapping("/categorias/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Categoria categoria = null;
		Map<String, Object> response = new HashMap();

		try {
			categoria = categoriaService.findById(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (categoria == null) {
			response.put("mensaje", "la categoria ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
	}
	
	@PostMapping("/categorias")
	public ResponseEntity<?> create(@RequestBody Categoria categoria, BindingResult result) {
		Categoria nuevaCategoria=null;
		Map<String, Object> response = new HashMap();
		
		if(result.hasErrors()) {
			List<String> errors=result.getFieldErrors()
					.stream()
					.map(err->"El campo '"+err.getField()+"' "+err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			nuevaCategoria=categoriaService.save(categoria);
			
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La categoria se creo con exito");
		response.put("categoria", nuevaCategoria);
		return new ResponseEntity<Map<String,Object>>(response ,HttpStatus.CREATED);
	}
	
	@PutMapping("/categorias/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Categoria categoria,BindingResult result, @PathVariable Long id) {
		Categoria categoriaActual=categoriaService.findById(id);
		Categoria categoriaActualizada=null; 
		Map<String, Object> response = new HashMap();
		
		if(result.hasErrors()) {
			List<String> errors=result.getFieldErrors()
					.stream()
					.map(err->"El campo '"+err.getField()+"' "+err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (categoriaActual == null) {
			response.put("mensaje", "Error, no se puede editar, la categoria ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			categoriaActual.setCantPersonas(categoria.getCantPersonas());
			categoriaActual.setNombre(categoria.getNombre());
			categoriaActual.setServicios(categoria.getServicios());

			categoriaActualizada= categoriaService.save(categoriaActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la categoria en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La categoria se actualizo con exito");
		response.put("categoria", categoriaService);
		return new ResponseEntity<Map<String,Object>>(response ,HttpStatus.CREATED);	
	}
	
	@Transactional
    @PutMapping("/categorias/{id}/estado")
    public ResponseEntity<String> cambiarEstadoCategoria(@PathVariable long id) {
        try {
        	categoriaService.cambiarEstadoCategoria(id);
            return ResponseEntity.ok("Estado de la categoria se ha cambiado correctamente.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La categoria con ID " + id + " no existe.");
        }
    }
}

