package com.proyecto.integrador.hotel.libertador.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
public class Servicio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String nombre;
	
	private Double costo;
	
	@NotNull(message = "La fecha de alta no puede ser nullo")
	@Temporal(TemporalType.DATE)
	private Date fechaAlta;
	/*
	 * @PrePersist public void prePersist() { fechaAlta=new Date(); }
	 */
	@Temporal(TemporalType.DATE)
	private Date fechaBaja;
	
	@Column(nullable = false)
	private String estado;
	
	@JsonIgnoreProperties({"servicios", "hibernateLazyInitializer", "handler"})
	@ManyToMany(mappedBy = "servicios", fetch = FetchType.LAZY)
	private List<Categoria> categorias;
	
	@OneToMany(mappedBy = "servicio")
	private List<Archivos> foto;
	public Servicio() {
	}

	public Servicio(Long id, String nombre, Double costo, Date fechaAlta, Date fechaBaja, String estado
			/*List<Categoria> categorias*/) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.estado = estado;
		//this.categorias = categorias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "Servicio [id=" + id + ", nombre=" + nombre + ", costo=" + costo + ", fechaAlta=" + fechaAlta
				+ ", fechaBaja=" + fechaBaja + ", estado=" + estado + " ]";
	}
	
	
	public List<Archivos> getFoto() {
		return foto;
	}

	public void setFoto(List<Archivos> foto) {
		this.foto = foto;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}


	private static final long serialVersionUID = 1L;
}
