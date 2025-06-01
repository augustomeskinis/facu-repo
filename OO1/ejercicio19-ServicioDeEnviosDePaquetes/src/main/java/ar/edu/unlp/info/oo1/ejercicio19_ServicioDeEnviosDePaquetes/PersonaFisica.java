package ar.edu.unlp.info.oo1.ejercicio19_ServicioDeEnviosDePaquetes;

import java.time.LocalDate;

public class PersonaFisica extends Cliente {
	private int DNI;

	public PersonaFisica(int DNI, String nombre, String direccion) {
		super(nombre, direccion);
		this.DNI = DNI;
	}
	
	@Override
	public double calcularMonto (LocalDate from, LocalDate to) {
		return super.calcularMonto(from, to) * 0.90;
	}
	
	
	
	
	
	
}
