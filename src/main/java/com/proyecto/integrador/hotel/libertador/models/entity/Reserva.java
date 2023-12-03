package com.proyecto.integrador.hotel.libertador.models.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
public class Reserva implements Serializable{	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@JsonIgnoreProperties(value={"reservas","hibernateLazyInitializer","handler"}, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
	@JsonManagedReference("detalles-reservas")
    @OneToMany(fetch = FetchType.LAZY, cascade =CascadeType.ALL)
    @JoinColumn(name="reserva_id")
    private List<DetalleReserva> detalleReserva;
    
    @Temporal(TemporalType.DATE)
    private Date fechaReserva;

	
	public Double getTotal() {
		Double total=0.0;
		for(DetalleReserva detalle:detalleReserva){
			total+=detalle.getImporte();
		}
		return total;
	}
	
	public Reserva() {
		this.detalleReserva=new ArrayList<>();
		
	}
    
	public Reserva(Long id, Usuario usuario, List<DetalleReserva> detalleReserva, Date fechaReserva) {
		this.id = id;
		this.usuario = usuario;
		this.detalleReserva = detalleReserva;
		this.fechaReserva = fechaReserva;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<DetalleReserva> getDetalleReserva() {
		return detalleReserva;
	}

	public void setDetalleReserva(List<DetalleReserva> detalleReserva) {
		this.detalleReserva = detalleReserva;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	
	
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", usuario=" + usuario + ", detalleReserva=" + detalleReserva + ", fechaReserva="
				+ fechaReserva + "]";
	}



	private static final long serialVersionUID = 1L;
}
