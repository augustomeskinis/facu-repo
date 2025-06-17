package ar.edu.unlp.info.oo1.ejercicio18_PoliticasDeCancelacion;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private String direccion;
	private int DNI;
	private List <Propiedad> propiedades;
	
	
	public Usuario (String nombre, String direccion, int DNI) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.DNI = DNI;
		this.propiedades = new ArrayList <Propiedad> ();
	}
	
	
	public void añadirPropiedad (Propiedad propiedad) {
		this.propiedades.add(propiedad);
	}
	
	
	public boolean reservar (Propiedad propiedad, DateLapse dateLapse) {
		if (propiedad.consultarDisponibilidad(dateLapse)) {
			Reserva reserva = new Reserva (this,dateLapse);
			propiedad.añadirReserva(reserva);
			return true;
		}
		return false;
	}
	
	
}
