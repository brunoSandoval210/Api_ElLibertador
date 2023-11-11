package com.proyecto.integrador.hotel.libertador.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DetalleReserva implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy = "detalleReservasHabitaciones")
    private List<Habitacion> Listahabitaciones;
    @OneToMany(mappedBy = "detalleReservasSalones")
    private List<Salon> listaSalones;
    @Temporal(TemporalType.DATE)
    private Date checkIn;
    @Temporal(TemporalType.DATE)
    private Date chackOut;
    @OneToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;
    private int cantidadHabitaciones;
    private int cantidadSalones;

}
