package ar.edu.unlp.info.oo1.ejercicio19_ServicioDeEnviosDePaquetes;

import java.time.LocalDate;

public abstract class Envio {
	protected LocalDate fechaDespacho;
	protected String direccionOrigen;
	protected String direccionDestino;
	protected double peso;
	
	public Envio(LocalDate fechaDespacho, String direccionOrigen, String direccionDestino, double peso) {
		this.fechaDespacho = fechaDespacho;
		this.direccionOrigen = direccionOrigen;
		this.direccionDestino = direccionDestino;
		this.peso = peso;
	}
	
	public abstract double costo ();

	public LocalDate getFechaDespacho() {
		return fechaDespacho;
	}

	public String getDireccionOrigen() {
		return direccionOrigen;
	}

	public String getDireccionDestino() {
		return direccionDestino;
	}

	public double getPeso() {
		return peso;
	}
	
	
	
	
}
