package com.proyecto.integrador.hotel.libertador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping
public class DetalleRestController {
	@Autowired
	private IDetalleReservaService detalleService;
	
	@GetMapping("/detalles")
	public List<DetalleReserva> index(){
		return detalleService.findAll();
	}
	
	@PostMapping({"detalles"})
	public DetalleReserva create(@RequestBody DetalleReserva detalle) {
		DetalleReserva nuevoDetalle=null;
		return nuevoDetalle=detalleService.save(detalle);
	}
	
	//nose si se implementara
	@PutMapping({"detalles/{id}"})
	public DetalleReserva update(@RequestBody DetalleReserva detalle, @PathVariable Long id) {
		DetalleReserva detalleActual=detalleService.findById(id);
		DetalleReserva detalleActualizado=null;
		//Falta agregar lo que se actualizara
		
		return detalleActualizado=detalleService.save(detalleActualizado);
	}

}
