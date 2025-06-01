package ar.edu.unlp.info.oo1.ejercicio18_PoliticasDeCancelacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Propiedad {
	private String direccion;
	private String nombre;
	private double precioPorNoche;
	private List <Reserva> reservas;
	private PoliticaDeCancelacion politicaDeCancelacion;
	
	public Propiedad (String direccion, String nombre, double precioPorNoche
					,PoliticaDeCancelacion politicaDeCancelacion) {
		this.direccion = direccion;
		this.nombre = nombre;
		this.precioPorNoche = precioPorNoche;
		this.reservas = new ArrayList <Reserva>  ();
		this.politicaDeCancelacion = politicaDeCancelacion;
		
	}
	
	public void añadirReserva (Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public boolean consultarDisponibilidad (DateLapse dateLapse) {
		return !(this.reservas.stream().anyMatch(reserva -> reserva.overlaps(dateLapse)));
	}
	
	public double cancelarReserva (Reserva reserva) {
		this.reservas.remove(reserva);
		double montoDeLaReserva = reserva.calcularPrecio(precioPorNoche);
		LocalDate fechaInicio = reserva.getDateLapse().getFrom();
		return politicaDeCancelacion.reembolsar(fechaInicio,montoDeLaReserva);
	}
	
	public double calcularIngresos () {
		return (this.reservas.stream()
				.mapToDouble(reserva -> reserva.calcularPrecio(this.precioPorNoche))
				.sum())
				* 0.75 ;
				
	}
	
	
}
