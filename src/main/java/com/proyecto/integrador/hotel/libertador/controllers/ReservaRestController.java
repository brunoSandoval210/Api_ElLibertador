package com.proyecto.integrador.hotel.libertador.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.integrador.hotel.libertador.models.entity.Reserva;
import com.proyecto.integrador.hotel.libertador.models.service.IReservaService;

@CrossOrigin(origins= {"http://localhost:5173"})
@RestController
@RequestMapping("/api")
public class ReservaRestController {
	
	@Autowired
	private IReservaService reservaService;
	
	@GetMapping("/reservas")
	public List<Reserva> index(){
		return reservaService.findAll();	
	}
	
	@GetMapping("/reservas/page/{page}")
	public Page<Reserva> index(@PathVariable Integer page) {
	    Pageable pageable = PageRequest.of(page, 10);
	    return reservaService.findAll(pageable);
	}
	
	@GetMapping("/reservas/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Reserva reserva = null;
		Map<String, Object> response = new HashMap();

		try {
			reserva = reservaService.findById(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (reserva == null) {
			response.put("mensaje", "La reserva ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Reserva>(reserva, HttpStatus.OK);
	}
	
	
	@Transactional
	@PostMapping("/reservas")
	public ResponseEntity<?> create(@RequestBody Reserva reserva, BindingResult result) {
		Reserva nuevaReserva=null;
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
			nuevaReserva=reservaService.save(reserva);
			
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La reserva se creó con éxito");
	    response.put("idReserva", nuevaReserva.getId());  // Devuelve el ID
	    response.put("url", "/api/reservas/" + nuevaReserva.getId());  // Devuelve la URL
	    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/reservas/dni/{dni}")
    public ResponseEntity<?> findByUsuarioDni(@PathVariable int dni) {
        List<Reserva> reservas = null;
        Map<String, Object> response = new HashMap<>();

        try {
            reservas = reservaService.findByUsuarioDni(dni);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (reservas.isEmpty()) {
            response.put("mensaje", "No hay reservas para el usuario con DNI: " + dni);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Reserva>>(reservas, HttpStatus.OK);
    }
}
