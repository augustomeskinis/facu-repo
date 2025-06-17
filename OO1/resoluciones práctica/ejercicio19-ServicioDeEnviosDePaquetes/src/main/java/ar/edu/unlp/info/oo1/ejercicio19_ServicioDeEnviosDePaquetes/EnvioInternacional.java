package ar.edu.unlp.info.oo1.ejercicio19_ServicioDeEnviosDePaquetes;

import java.time.LocalDate;

public class EnvioInternacional extends Envio {

	public EnvioInternacional (LocalDate fechaDespacho, String direccionOrigen, String direccionDestino, double peso) {
		super(fechaDespacho,direccionOrigen,direccionDestino,peso);
		
	}
	
	public double costo() {
		if(this.peso < 1000) {
			return 5000*10;
		}
		return 5000*12;
	}
}
