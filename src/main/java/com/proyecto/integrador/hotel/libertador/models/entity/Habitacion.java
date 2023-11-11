package com.proyecto.integrador.hotel.libertador.models.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Habitacion implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numHabitacion;
    private double costohabitacion;
    @ManyToOne
    @JoinColumn(name ="Id_categoria_habitacion" )
    private Categoria tipoHabitacion; 
    private int maxPersonas;
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    //Falta modificar
    private String ocupantes;
    private String estado;
    
    @ManyToOne
    @JoinColumn(name= "Id_detalleReserva")
    private DetalleReserva detalleReservasHabitaciones;
}
