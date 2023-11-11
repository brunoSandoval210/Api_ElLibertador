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
public class Servicio implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable  = false)
    private String nombre;
    private double costo;
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Temporal(TemporalType.DATE)
    @PrePersist
    public void prePersist() {
    	fechaAlta=new Date();
    }
    private Date fechaBaja;
    @Column(nullable  = false)
    private String estado;
    @ManyToMany
    @JoinTable(
        name = "ServicioCategoria",
        joinColumns = @JoinColumn(name = "id_servicio"),
        inverseJoinColumns = @JoinColumn(name = "id_categoria")
    )
    private List<Categoria>categorias;
    
    public Servicio() {}
	public Servicio(Long id, String nombre, double costo, Date fechaAlta, Date fechaBaja, String estado,
			List<Categoria> categorias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.estado = estado;
		this.categorias = categorias;
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
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
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
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	@Override
	public String toString() {
		return "Servicio [id=" + id + ", nombre=" + nombre + ", costo=" + costo + ", fechaAlta=" + fechaAlta
				+ ", fechaBaja=" + fechaBaja + ", estado=" + estado + ", categorias=" + categorias + "]";
	}
	
    
    
}
