package ar.edu.unlp.info.oo1.ejercicio19_ServicioDeEnviosDePaquetes;

import java.time.LocalDate;

public class EnvioLocal extends Envio{
	private boolean entregaRapida;
	
	public EnvioLocal(LocalDate fechaDespacho, String direccionOrigen, String direccionDestino, double peso,
			boolean entregaRapida) {
		super(fechaDespacho,direccionOrigen,direccionDestino, peso);
		this.entregaRapida = entregaRapida;
	}
	
	public double costo() {
		if(entregaRapida) {
			return 1500;
		}
		return 1000;
	}
	
	
}
