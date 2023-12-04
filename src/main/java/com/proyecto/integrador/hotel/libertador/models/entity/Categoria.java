package com.proyecto.integrador.hotel.libertador.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Categoria implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String nombre;
	private int cantPersonas;
	@Temporal(TemporalType.DATE)
	private Date fechaAlta;

	@PrePersist
	public void prePersist() {
		fechaAlta = new Date();
	}

	@Temporal(TemporalType.DATE)
	private Date fechaBaja;
	@Column(nullable = false)
	private String estado;
	
	@JsonManagedReference("categoria-archivos")
	@OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Archivos> foto;
	private String descripcion_breve;

	@Column(columnDefinition = "TEXT")
	private String descripcion_larga;
	private double precioCategoria;

	@JsonIgnoreProperties(value={ "categorias", "hibernateLazyInitializer", "handler" },allowSetters = true)
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "servicio_categoria", joinColumns = @JoinColumn(name = "id_categoria"), inverseJoinColumns = @JoinColumn(name = "id_servicio"))
	private List<Servicio> servicios;
	/*
	 * @JsonIgnoreProperties({"tipoSalon", "hibernateLazyInitializer", "handler"})
	 * 
	 * @OneToMany(mappedBy = "tipoSalon", fetch = FetchType.LAZY) private
	 * List<Salon> salones;
	 */

	@JsonIgnoreProperties(value={ "tipoHabitacion", "hibernateLazyInitializer", "handler" },allowSetters = true)
	@OneToMany(mappedBy = "tipoHabitacion", fetch = FetchType.LAZY)
	private List<Habitacion> habitaciones;

	public Categoria() {
	}

	public Categoria(Long id, String nombre, int cantPersonas, Date fechaAlta, Date fechaBaja, String estado,
			List<Archivos> foto, String descripcion_breve, String descripcion_larga, double precioCategoria,
			List<Servicio> servicios, List<Habitacion> habitaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantPersonas = cantPersonas;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.estado = estado;
		this.foto = foto;
		this.descripcion_breve = descripcion_breve;
		this.descripcion_larga = descripcion_larga;
		this.precioCategoria = precioCategoria;
		this.servicios = servicios;
		this.habitaciones = habitaciones;
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

	public int getCantPersonas() {
		return cantPersonas;
	}

	public void setCantPersonas(int cantPersonas) {
		this.cantPersonas = cantPersonas;
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

	public List<Archivos> getFoto() {
		return foto;
	}

	public void setFoto(List<Archivos> foto) {
		this.foto = foto;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public String getDescripcion_breve() {
		return descripcion_breve;
	}

	public void setDescripcion_breve(String descripcion_breve) {
		this.descripcion_breve = descripcion_breve;
	}

	public String getDescripcion_larga() {
		return descripcion_larga;
	}

	public void setDescripcion_larga(String descripcion_larga) {
		this.descripcion_larga = descripcion_larga;
	}

	public double getPrecioCategoria() {
		return precioCategoria;
	}

	public void setPrecioCategoria(double precioCategoria) {
		this.precioCategoria = precioCategoria;
	}

	/*
	 * public List<Salon> getSalones() { return salones; }
	 * 
	 * public void setSalones(List<Salon> salones) { this.salones = salones; }
	 * 
	 * public List<Habitacion> getHabitaciones() { return habitaciones; }
	 * 
	 * public void setHabitaciones(List<Habitacion> habitaciones) {
	 * this.habitaciones = habitaciones; }
	 */

	public Double getCostoServicios() {
		double total = 0.0;
		List<Servicio> listaservicios = getServicios();
		if (listaservicios != null) {
			for (Servicio servi : listaservicios) {
				total = total + servi.getCosto();
			}
		} else {
			total = 0.0;
		}
		return total;
	}

	public Double getCostoTotalCategoria() {
		return getCostoServicios() + getPrecioCategoria();
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", cantPersonas=" + cantPersonas + ", fechaAlta="
				+ fechaAlta + ", fechaBaja=" + fechaBaja + ", estado=" + estado + ", foto=" + foto + ", servicios="
				+ servicios + ", habitaciones=" + habitaciones + "]";
	}

	private static final long serialVersionUID = 1L;

}