package com.proyecto.integrador.hotel.libertador.models.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Habitacion implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty(message = "El numero de habitacion no puede estar vacio")
	@Column(unique = true)
    private int numHabitacion;
	
	@NotEmpty(message = "El costo de la habitacion no puede estar vacio")
    private double costohabitacion;
    
    private int maxPersonas;
    
    @NotNull(message = "La fecha de alta no puede ser nullo")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    
    private String ocupante;
    
    @Column(nullable = false)
    private String estado;
    
    private String disponibilidad;
    
    private String foto;

    @JsonIgnoreProperties({"habitaciones","hibernateLazyInitializer","handler"})
    @ManyToOne
    @JoinColumn(name ="Id_categoria_habitacion")
    @NotEmpty(message = "La categoria de la habitacion no puede estar vacia")
    private Categoria tipoHabitacion; 
    
	public Habitacion() {
	}

	public Habitacion(Long id, int numHabitacion, double costohabitacion, Categoria tipoHabitacion, int maxPersonas,
			Date fechaAlta, Date fechaBaja, String ocupante, String estado, String disponibilidad,
			DetalleReserva detalleReservasHabitaciones) {
		this.id = id;
		this.numHabitacion = numHabitacion;
		this.costohabitacion = costohabitacion;
		this.tipoHabitacion = tipoHabitacion;
		this.maxPersonas = maxPersonas;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.ocupante = ocupante;
		this.estado = estado;
		this.disponibilidad = disponibilidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}

	public double getCostohabitacion() {
		return costohabitacion;
	}

	public void setCostohabitacion(double costohabitacion) {
		this.costohabitacion = costohabitacion;
	}

	public Categoria getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(Categoria tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public int getMaxPersonas() {
		return maxPersonas;
	}

	public void setMaxPersonas(int maxPersonas) {
		this.maxPersonas = maxPersonas;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getOcupante() {
		return ocupante;
	}

	public void setOcupante(String ocupante) {
		this.ocupante = ocupante;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Habitacion [id=" + id + ", numHabitacion=" + numHabitacion + ", costohabitacion=" + costohabitacion
				+ ", tipoHabitacion=" + tipoHabitacion + ", maxPersonas=" + maxPersonas + ", fechaAlta=" + fechaAlta
				+ ", fechaBaja=" + fechaBaja + ", ocupante=" + ocupante + ", estado=" + estado + ", disponibilidad="
				+ disponibilidad + ", foto=" + foto + "]";
	}
	
	private static final long serialVersionUID = 1L;
}
