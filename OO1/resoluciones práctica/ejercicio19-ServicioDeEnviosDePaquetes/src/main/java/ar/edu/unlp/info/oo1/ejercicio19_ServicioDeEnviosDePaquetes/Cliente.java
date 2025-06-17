package ar.edu.unlp.info.oo1.ejercicio19_ServicioDeEnviosDePaquetes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	protected String nombre;
	protected String direccion;
	protected List<Envio>envios;
	
	
	public Cliente (String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.envios = new ArrayList<Envio>();
	}
	
	public void agregarEnvio (Envio envio) {
		this.envios.add(envio);
	}
	
	public double calcularMonto (LocalDate from, LocalDate to) {
		DateLapse dateLapse = new DateLapse (from,to);
		return this.envios.stream()
		.filter(envio -> dateLapse.includesDate(envio.getFechaDespacho()))
		.mapToDouble(envio -> envio.costo())
		.sum();
	}
	
	
}
