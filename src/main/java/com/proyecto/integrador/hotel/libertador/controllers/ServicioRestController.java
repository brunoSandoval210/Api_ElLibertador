package com.proyecto.integrador.hotel.libertador.controllers;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.integrador.hotel.libertador.models.entity.Servicio;
import com.proyecto.integrador.hotel.libertador.models.entity.Usuario;
import com.proyecto.integrador.hotel.libertador.models.service.IServicioService;
import com.proyecto.integrador.hotel.libertador.models.service.IUploadFileService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@CrossOrigin(origins= {"http://localhost:5173"})
@RestController
@RequestMapping("/api")
public class ServicioRestController {
	@Autowired
	private IServicioService servicioService;
	
	@Autowired
	private IUploadFileService uploadService;
	
	private final Logger log=LoggerFactory.getLogger(ServicioRestController.class);
	
	@GetMapping("/servicios")
	public List<Servicio> index(){
		return servicioService.findAll();	
	}
	
	@GetMapping("/servicios/page/{page}")
	public Page<Servicio> index(@PathVariable Integer page) {
	    Pageable pageable = PageRequest.of(page, 4);
	    return servicioService.findAll(pageable);
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
	public ResponseEntity<?> create(@RequestBody Servicio servicio, BindingResult result) {
		Servicio nuevoServicio=null;
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
	public ResponseEntity<?> update(@Valid @RequestBody Servicio servicio, BindingResult result, @PathVariable Long id) {
		Servicio servicioACtual=servicioService.findById(id);
		Servicio servicioActualizado=null; 
		
		Map<String, Object> response = new HashMap();
		
		if(result.hasErrors()) {
			List<String> errors=result.getFieldErrors()
					.stream()
					.map(err->"El campo '"+err.getField()+"' "+err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (servicioACtual == null) {
			response.put("mensaje", "Error, no se puede editar, el servicio ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			servicioACtual.setCosto(servicio.getCosto());
			servicioACtual.setNombre(servicio.getNombre());
			
			servicioActualizado= servicioService.save(servicioACtual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el servicio en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El servicio se actualizo con exito");
		response.put("servicio", servicioACtual);
		return new ResponseEntity<Map<String,Object>>(response ,HttpStatus.CREATED);	
	}
	
	@DeleteMapping("/servicios/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap();
		
		try {
			Servicio servicio=servicioService.findById(id);
			String nombreFotoAnterior=servicio.getFoto();
			
			uploadService.eliminar(nombreFotoAnterior);
			servicioService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al elimnar el servicio en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El servicio eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("servicios/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		Map<String, Object> response = new HashMap();
		
		Servicio servicio=servicioService.findById(id);
		
		if(!archivo.isEmpty()) {
			String nombreArchivo=null;
			try {
				nombreArchivo=uploadService.copiar(archivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen");
				response.put("error", e.getMessage().concat(":").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			String nombreFotoAnterior=servicio.getFoto();
			
			uploadService.eliminar(nombreFotoAnterior);
			
			servicio.setFoto(nombreArchivo);
			servicioService.save(servicio);
			response.put("servicio", servicio);
			response.put("mensaje", "Se ha subido correctamente la imagen"+nombreArchivo);
		}
		return new ResponseEntity<Map<String,Object>>(response ,HttpStatus.CREATED);	
	}
	
	@Transactional
    @PutMapping("/servicios/{id}/estado")
    public ResponseEntity<String> cambiarEstadoServicio(@PathVariable long id) {
        try {
            servicioService.cambiarEstadoServicio(id);
            return ResponseEntity.ok("Estado del servicio cambiado correctamente.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El servicio con ID " + id + " no existe.");
        }
    }
	
	@GetMapping("/servicios/por-ids")
    public ResponseEntity<List<Servicio>> obtenerServiciosPorIds(@RequestParam List<Long> ids) {
        List<Servicio> servicios = servicioService.findByIds(ids);

        if (servicios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(servicios);
        }

        return ResponseEntity.ok(servicios);
    }
}
