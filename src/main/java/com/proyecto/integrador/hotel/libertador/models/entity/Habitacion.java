package com.proyecto.integrador.hotel.libertador.models.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Habitacion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// @NotEmpty(message = "El nombre de la habitacion no puede estar vacio")
	private String nombre;

	@NotNull(message = "El número de habitación no puede ser nulo")
	@Column(name = "num_habitacion")
	private int numHabitacion;


	private Double costohabitacion;

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

	@JsonManagedReference("habitacion-archivos")
	@OneToMany(mappedBy = "habitacion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Archivos> foto;

	@JsonIgnoreProperties({ "habitaciones", "hibernateLazyInitializer", "handler" })
	@ManyToOne
	@JoinColumn(name = "Id_categoria_habitacion")
	@NotNull(message = "El tipo de habitación no puede ser nulo")
	private Categoria tipoHabitacion;

	@OneToMany(mappedBy = "habitaciones", cascade = CascadeType.ALL)
	private List<DetalleReserva> detalleReservasHabitaciones;

	public Habitacion() {
	}

	public Habitacion(Long id, int numHabitacion, Double costohabitacion, Categoria tipoHabitacion, int maxPersonas,
			Date fechaAlta, Date fechaBaja, String ocupante, String estado, String disponibilidad,
			DetalleReserva detalleReservasHabitaciones, String nombre) {
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
		this.nombre = nombre;
	}
	

	public List<Date> FechasReservadas() {
	    List<Date> fechasReservadas = new ArrayList<>();
	    if (detalleReservasHabitaciones != null) {
	        for (DetalleReserva detalleReserva : detalleReservasHabitaciones) {
	            Date checkIn = detalleReserva.getCheckIn();
	            Date checkOut = detalleReserva.getChackOut();
	            Calendar calendar = Calendar.getInstance();
	            calendar.setTime(checkIn);
	            while (!calendar.getTime().after(checkOut)) {
	                fechasReservadas.add(calendar.getTime());
	                calendar.add(Calendar.DATE, 1);
	            }
	        }
	    }
	    return fechasReservadas;
	}
	private String formatearFecha(Date fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YY");
		return sdf.format(fecha);
	}
	
	public List<String> getFechasReservadas() {
	    List<Date> fechasReservadas = FechasReservadas();
	    List<String> fechasReservadasFormateadas = new ArrayList<>();
	    for (Date fecha : fechasReservadas) {
	        fechasReservadasFormateadas.add(formatearFecha(fecha));
	    }
	    return fechasReservadasFormateadas;
	}

	public Double getCostoServicios() {
		Categoria tipo = getTipoHabitacion();
		double precioServicios = tipo.getCostoServicios();
		return precioServicios;
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

	public Double getCostohabitacion() {
		Categoria tipo=getTipoHabitacion();
		double precioHabitacion=tipo.getPrecioCategoria();
		return precioHabitacion;
	}

	public void setCostohabitacion(Double costohabitacion) {
		this.costohabitacion = costohabitacion;
	}

	public Categoria getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(Categoria tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public int getMaxPersonas() {
		Categoria tipo=getTipoHabitacion();
		int max=tipo.getCantPersonas();
		return max;
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

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDisponibilidad() {
		List<Date> fechasReservadas = FechasReservadas();

		if (fechasReservadas.isEmpty()) {
			// Si no hay fechas reservadas, la habitación está disponible
			return "Disponible";
		} else {
			Date fechaActual = new Date();

			for (int i = 0; i < fechasReservadas.size(); i += 2) {
				Date checkIn = fechasReservadas.get(i);
				Date checkOut = fechasReservadas.get(i + 1);

				if (!fechaActual.before(checkIn) && fechaActual.before(checkOut)) {
					// La fecha actual está después del check-in y antes del check-out, la
					// habitación está reservada
					return "No Disponible";
				}
			}

			// Si no está dentro de ningún período de reserva, la habitación está disponible
			return "Disponible";
		}
	}


	public List<Archivos> getFoto() {
		return foto;
	}

	public void setFoto(List<Archivos> foto) {
		this.foto = foto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Habitacion [id=" + id + ", numHabitacion=" + numHabitacion + ", costohabitacion=" + costohabitacion
				+ ", tipoHabitacion=" + tipoHabitacion + ", maxPersonas=" + maxPersonas + ", fechaAlta=" + fechaAlta
				+ ", fechaBaja=" + fechaBaja + ", ocupante=" + ocupante + ", estado=" + estado + ", disponibilidad="
				+ disponibilidad + ", foto=" + foto + "]";
	}

	public Double getCostoTotalHabitacion() {
		double total = getCostoServicios() + getCostohabitacion();
		return total;
	}
	
	

	private static final long serialVersionUID = 1L;
}