package com.proyecto.integrador.hotel.libertador.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "No puede estar vacio")
	@Email
	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)				
	private String contrasena;

	@Column(nullable = false, unique = true)
	private int DNI;

	@NotEmpty(message = "No puede estar vacio")
	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String apellido;

	@Column(nullable = false)
	private int telefono;

	@Column(nullable = false)
	private String tipo;

	@NotNull(message = "La fecha de alta no puede ser nullo")
	@Temporal(TemporalType.DATE)
	private Date fechaAlta;

	/*
	 * @PrePersist public void prePersist() { fechaAlta=new Date(); }
	 */

	@Temporal(TemporalType.DATE)
	private Date fechaBaja;

	private String estado;
	@JsonIgnoreProperties(value={"usuario","hibernateLazyInitializer","handler"}, allowGetters = true)
	@OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Reserva> reservas;
	
	@OneToMany(mappedBy = "usuario")
	private List<Archivos> foto;

	public Usuario() {
		this.reservas=new ArrayList<>();
	}

	public Usuario(Long id, String email, String contrasena, int dNI,
			String nombre, String apellido, int telefono, String tipo,
			Date fechaAlta, Date fechaBaja, String estado,
			List<Reserva> reservas) {
		super();
		this.id = id;
		this.email = email;
		this.contrasena = contrasena;
		this.DNI = dNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.tipo = tipo;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.estado = estado;
		this.reservas = reservas;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}


	public List<Archivos> getFoto() {
		return foto;
	}

	public void setFoto(List<Archivos> foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", contrasena=" + contrasena + ", DNI=" + DNI + ", nombre="
				+ nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", tipo=" + tipo + ", fechaAlta="
				+ fechaAlta + ", fechaBaja=" + fechaBaja + ", estado=" + estado + ", reservas=" + reservas + "]";
	}
	
	private static final long serialVersionUID = 1L;

}
