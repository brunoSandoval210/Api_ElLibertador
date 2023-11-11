package com.proyecto.integrador.hotel.libertador.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.integrador.hotel.libertador.models.entity.Servicio;
import com.proyecto.integrador.hotel.libertador.models.service.IServicioService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ServicioRestController {
	@Autowired
	private IServicioService servicioService;
	
	@GetMapping("/servicios")
	public List<Servicio> index(){
		return servicioService.findAll();	
	}
	
	@GetMapping("/servicios/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Servicio servicio = null;
		Map<String, Object> response = new HashMap();

		try {
			servicio = servicioService.findById(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (servicio == null) {
			response.put("mensaje", "El servicio ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Servicio>(servicio, HttpStatus.OK);
	}
	
	@PostMapping("/servicios")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Servicio servicio) {
		Servicio nuevoServicio=null;
		Map<String, Object> response = new HashMap();
		try {
			nuevoServicio=servicioService.save(servicio);
			
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El servicio se creo con exito");
		response.put("servicio", nuevoServicio);
		return new ResponseEntity<Map<String,Object>>(response ,HttpStatus.CREATED);
	}
	
	@PutMapping("/servicios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Servicio update(@RequestBody Servicio servicio, @PathVariable Long id) {
		Servicio servicioActual=servicioService.findById(id);
	    servicioActual.setCosto(servicio.getCosto());
	    servicioActual.setNombre(servicio.getNombre());
	  
		return servicioService.save(servicioActual);
		
	}
	
	@DeleteMapping("/servicios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		servicioService.delete(id);
	}

}
