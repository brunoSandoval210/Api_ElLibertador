/*package com.proyecto.integrador.hotel.libertador.models.entity;
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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
public class Salon implements Serializable{
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty(message = "El numero de habitacion no puede estar vacio")
	@Column(unique = true)
    private double costoSalon;
	
	@JsonIgnoreProperties({"salones","hibernateLazyInitializer","handler"})
	@ManyToOne
	@NotEmpty(message = "La categoria del salon no puede estar vacia")
    @JoinColumn(name = "Id_categoria_salon")
    private Categoria tipoSalon;
    
    private int maxPersonas;
    
    private String ocupante;
    
    @NotNull(message = "La fecha de alta no puede ser nullo")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    
    @Column(nullable = false)
    private String estado;
    
    private String disponibilidad;
    
    private String foto;
    
    public Salon() {
		
	}
    
	public Salon(Long id, double costoSalon,
			Categoria tipoSalon, int maxPersonas,
			Date fechaAlta, Date fechaBaja, String ocupante,
			String estado, String disponibilidad, String foto) {
		this.id = id;
		this.costoSalon = costoSalon;
		this.tipoSalon = tipoSalon;
		this.maxPersonas = maxPersonas;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.ocupante = ocupante;
		this.estado = estado;
		this.disponibilidad = disponibilidad;
		this.foto = foto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCostoSalon() {
		return costoSalon;
	}

	public void setCostoSalon(double costoSalon) {
		this.costoSalon = costoSalon;
	}

	public Categoria getTipoSalon() {
		return tipoSalon;
	}

	public void setTipoSalon(Categoria tipoSalon) {
		this.tipoSalon = tipoSalon;
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
    
	private static final long serialVersionUID = 1L;


	@Override
	public String toString() {
		return "Salon [id=" + id + ", costoSalon=" + costoSalon + ", tipoSalon=" + tipoSalon + ", maxPersonas="
				+ maxPersonas + ", fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja + ", ocupante=" + ocupante
				+ ", estado=" + estado + ", disponibilidad=" + disponibilidad + ", foto=" + foto + "]";
	}
	
	
    
}*/
