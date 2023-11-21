package com.proyecto.integrador.hotel.libertador.controllers;

import java.io.IOException;
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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.integrador.hotel.libertador.models.entity.Habitacion;
import com.proyecto.integrador.hotel.libertador.models.service.IHabitacionService;
import com.proyecto.integrador.hotel.libertador.models.service.IUploadFileService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@CrossOrigin(origins= {"http://localhost:5173"})
@RestController
@RequestMapping("/api")
public class HabitacionRestController {
	@Autowired
	private IHabitacionService habitacionService;
	
	@Autowired
	private IUploadFileService uploadService;
	
	private final Logger log=LoggerFactory.getLogger(HabitacionRestController.class);
	
	@GetMapping("/habitaciones")
	public List<Habitacion> index() {
		return habitacionService.findAll();
	}
	
	@GetMapping("/habitaciones/page/{page}")
	public Page<Habitacion> index(@PathVariable Integer page) {
	    Pageable pageable = PageRequest.of(page, 10);
	    return habitacionService.findAll(pageable);
	}
	
	@GetMapping("/habitaciones/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Habitacion habitacion = null;
		Map<String, Object> response = new HashMap();

		try {
			habitacion = habitacionService.findById(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (habitacion == null) {
			response.put("mensaje", "La habitacion ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Habitacion>(habitacion, HttpStatus.OK);
	}
	
	@PostMapping("/habitaciones")
	public ResponseEntity<?> create(@Valid @RequestBody Habitacion habitacion, BindingResult result) {
		Habitacion nuevaHabitacion=null;
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
			nuevaHabitacion=habitacionService.save(habitacion);
			
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La habitacion se creo con exito");
		response.put("usuario", nuevaHabitacion);
		return new ResponseEntity<Map<String,Object>>(response ,HttpStatus.CREATED);
	}
	
	@PutMapping("/habitaciones/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Habitacion habitacion, BindingResult result, @PathVariable Long id) {
		Habitacion habitacionActual=habitacionService.findById(id);
		Habitacion habitacionActulizada=null; 
		
		Map<String, Object> response = new HashMap();
		
		if(result.hasErrors()) {
			List<String> errors=result.getFieldErrors()
					.stream()
					.map(err->"El campo '"+err.getField()+"' "+err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (habitacionActual == null) {
			response.put("mensaje", "Error, no se puede editar, la habitacion ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			habitacionActual.setNombre(habitacion.getNombre());
			habitacionActual.setCostohabitacion(habitacion.getCostohabitacion());
			habitacionActual.setMaxPersonas(habitacion.getMaxPersonas());
			habitacionActual.setTipoHabitacion(habitacion.getTipoHabitacion());
			
			habitacionActulizada= habitacionService.save(habitacionActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la habitacion en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "la habitacion se actualizo con exito");
		response.put("habitacion", habitacionActual);
		return new ResponseEntity<Map<String,Object>>(response ,HttpStatus.CREATED);	
	}
	
	@DeleteMapping("/habitaciones/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap();
		
		try {
			Habitacion habitacion=habitacionService.findById(id);
			String nombreFotoAnterior=habitacion.getFoto();
			
			uploadService.eliminar(nombreFotoAnterior);
			habitacionService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al elimnar la habitacion en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La habitacion eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("habitaciones/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		Map<String, Object> response = new HashMap();
		
		Habitacion habitacion=habitacionService.findById(id);
		
		if(!archivo.isEmpty()) {
			String nombreArchivo=null;
			try {
				nombreArchivo=uploadService.copiar(archivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen");
				response.put("error", e.getMessage().concat(":").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			String nombreFotoAnterior=habitacion.getFoto();
			
			uploadService.eliminar(nombreFotoAnterior);
			
			habitacion.setFoto(nombreArchivo);
			habitacionService.save(habitacion);
			response.put("habitacion", habitacion);
			response.put("mensaje", "Se ha subido correctamente la imagen"+nombreArchivo);
		}
		return new ResponseEntity<Map<String,Object>>(response ,HttpStatus.CREATED);	
	}
	@Transactional
    @PutMapping("/habitaciones/{id}/estado")
    public ResponseEntity<String> cambiarEstadoHabitacion(@PathVariable long id) {
        try {
        	habitacionService.cambiarEstadoHabitacion(id);
            return ResponseEntity.ok("Estado la habitacion se ha cambiado correctamente.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La habitacion con ID " + id + " no existe.");
        }
    }
	
	@GetMapping("/habitaciones/disponibles")
	public ResponseEntity<?> getHabitacionesDisponibles(
	        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaCheckIn,
	        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaCheckOut) {
	    try {
	        List<Habitacion> habitacionesDisponibles = habitacionService.obtenerHabitacionesDisponibles(fechaCheckIn, fechaCheckOut);
	        return new ResponseEntity<>(habitacionesDisponibles, HttpStatus.OK);
	    } catch (Exception e) {
	        Map<String, Object> response = new HashMap<>();
	        response.put("mensaje", "Error al obtener las habitaciones disponibles");
	        response.put("error", e.getMessage());
	        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
}
