package com.proyecto.integrador.hotel.libertador.models.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
public class DetalleReserva implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "El checkIn no puede ser nullo")
	@Temporal(TemporalType.DATE)
    private Date checkIn;
    
    @NotNull(message = "El checkOut no puede ser nullo")
    @Temporal(TemporalType.DATE)
    private Date chackOut;
    
    
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_habitacion")
    private Habitacion habitaciones;
    
    /*@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_salon")
    private Salon salones;*/
    
    
    @JsonBackReference("detalles-reservas")
    @ManyToOne(fetch = FetchType.LAZY)
    private Reserva reserva;
    
    public Double getImporte() {
        Double importeHabitaciones = 0.0;

        if (habitaciones != null) {
            importeHabitaciones =  habitaciones.getCostoTotalHabitacion();
        }

        /*if (salones != null) {
            importeSalones = cantidadSalones * salones.getCostoSalon();
        }*/

        return importeHabitaciones ;
    }
	
	public DetalleReserva() {

	}

	public DetalleReserva(Long id,  Date checkIn, Date chackOut, Habitacion habitaciones /*Salon salones*/) {
		this.id = id;
		this.checkIn = checkIn;
		this.chackOut = chackOut;
		this.habitaciones = habitaciones;
		//this.salones = salones;
	}
	
	
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getChackOut() {
		return chackOut;
	}

	public void setChackOut(Date chackOut) {
		this.chackOut = chackOut;
	}


	public Habitacion getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Habitacion habitaciones) {
		this.habitaciones = habitaciones;
	}

	/*public Salon getSalones() {
		return salones;
	}

	public void setSalones(Salon salones) {
		this.salones = salones;
	}*/


	private static final long serialVersionUID = 1L;

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}
