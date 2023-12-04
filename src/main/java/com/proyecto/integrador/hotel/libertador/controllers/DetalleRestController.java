package com.proyecto.integrador.hotel.libertador.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.integrador.hotel.libertador.models.entity.DetalleReserva;
import com.proyecto.integrador.hotel.libertador.models.service.IDetalleReservaService;

@CrossOrigin(origins = {"http://localhost:5173"})
@RestController
@RequestMapping("/api")
public class DetalleRestController {
	@Autowired
	private IDetalleReservaService detalleService;
	
	@GetMapping("/detalles")
	public List<DetalleReserva> index(){
		return detalleService.findAll();
	}
	
	@Transactional
	@PostMapping("/detalles")
    public ResponseEntity<?> create(@RequestBody DetalleReserva detalle) {
        DetalleReserva nuevoDetalle = detalleService.save(detalle);

        Map<String, Object> response = new HashMap();
        response.put("mensaje", "Detalle de reserva creado con éxito");
        response.put("idDetalle", nuevoDetalle.getId());
        response.put("url", "/api/detalles/" + nuevoDetalle.getId());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
	

}
