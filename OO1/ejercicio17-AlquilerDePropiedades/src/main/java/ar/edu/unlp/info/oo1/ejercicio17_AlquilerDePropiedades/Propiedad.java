package ar.edu.unlp.info.oo1.ejercicio17_AlquilerDePropiedades;

import java.util.ArrayList;
import java.util.List;

public class Propiedad {
	private String direccion;
	private String nombre;
	private double precioPorNoche;
	private List <Reserva> reservas;
	
	public Propiedad (String direccion, String nombre, double precioPorNoche) {
		this.direccion = direccion;
		this.nombre = nombre;
		this.precioPorNoche = precioPorNoche;
		this.reservas = new ArrayList <Reserva>  ();
	}
	
	public void añadirReserva (Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public boolean consultarDisponibilidad (DateLapse dateLapse) {
		return !(this.reservas.stream().anyMatch(reserva -> reserva.overlaps(dateLapse)));
	}
	
	public void cancelarReserva (Reserva reserva) {
		this.reservas.remove(reserva);
	}
	
	
	public double calcularIngresos () {
		return (this.reservas.stream()
				.mapToDouble(reserva -> reserva.calcularPrecio(this.precioPorNoche))
				.sum())
				* 0.75 ;
				
	}
	
	
}
