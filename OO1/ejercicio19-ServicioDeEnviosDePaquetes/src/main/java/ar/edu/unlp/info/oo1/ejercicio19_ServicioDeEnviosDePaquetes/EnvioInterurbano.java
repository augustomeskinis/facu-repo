package ar.edu.unlp.info.oo1.ejercicio19_ServicioDeEnviosDePaquetes;

import java.time.LocalDate;

public class EnvioInterurbano extends Envio {
	private double distanciaEnKm;
	
	public EnvioInterurbano (LocalDate fechaDespacho, String direccionOrigen,
			String direccionDestino, double peso, double distanciaEnKm) {
		super(fechaDespacho,direccionOrigen,direccionDestino,peso);
		this.distanciaEnKm = distanciaEnKm;
	}
	
	public double costo() {
		if (this.distanciaEnKm <= 100) {
			return 20*this.peso;
		}
		else if (this.distanciaEnKm <= 500) {
			return 25*this.peso;
		}
	return 30*this.peso;
	}
	
}
