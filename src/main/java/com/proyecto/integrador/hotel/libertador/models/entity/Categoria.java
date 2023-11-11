package com.proyecto.integrador.hotel.libertador.models.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Categoria implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable = false, unique = true)
    private String nombre;
    private double costoServicios;
    private int cantPersonas;
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @PrePersist
    public void prePersist() {
    	fechaAlta=new Date();
    }
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    @Column(nullable = false)
    private String estado;
    private String foto;
    
    @ManyToMany(mappedBy = "categorias")
    private List<Servicio> servicios;    
    
    @ManyToMany
    @JoinTable(
        name = "Categoria_Salon",
        joinColumns = @JoinColumn(name = "id_categoria"),
        inverseJoinColumns = @JoinColumn(name = "id_salon")
    )
    private List<Salon> salones;

    @ManyToMany
    @JoinTable(
        name = "Categoria_Habitacion",
        joinColumns = @JoinColumn(name = "id_categoria"),
        inverseJoinColumns = @JoinColumn(name = "id_habitacion")
    )
    private List<Habitacion> habitaciones;
    
	public Categoria() {
		super();
	}

	public Categoria(Long id, String nombre, double costoServicios, int cantPersonas, Date fechaAlta, Date fechaBaja,
			String estado, String foto, List<Servicio> servicios, List<Salon> salones, List<Habitacion> habitaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.costoServicios = costoServicios;
		this.cantPersonas = cantPersonas;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.estado = estado;
		this.foto = foto;
		this.servicios = servicios;
		this.salones = salones;
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

	public double getCostoServicios() {
		return costoServicios;
	}

	public void setCostoServicios(double costoServicios) {
		this.costoServicios = costoServicios;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public List<Salon> getSalones() {
		return salones;
	}

	public void setSalones(List<Salon> salones) {
		this.salones = salones;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", costoServicios=" + costoServicios + ", cantPersonas="
				+ cantPersonas + ", fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja + ", estado=" + estado
				+ ", foto=" + foto + ", servicios=" + servicios + ", salones=" + salones + ", habitaciones="
				+ habitaciones + "]";
	}
    

}
