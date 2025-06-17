package ar.edu.unlp.info.oo1.ejercicio11_Inversor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo implements ValorActual {
	private LocalDate fechaDeConstruccion;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;

	public PlazoFijo(LocalDate fechaDeConstruccion, double montoDepositado, double porcentajeDeInteresDiario) {
		super();
		this.fechaDeConstruccion = fechaDeConstruccion;
		this.montoDepositado = montoDepositado;
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}
	public double valorActual (){
		LocalDate fechaActual = LocalDate.now();
		long diasEntre = ChronoUnit.DAYS.between(fechaDeConstruccion, fechaActual);
		double interesTotal = diasEntre * porcentajeDeInteresDiario;
		double aux = this.montoDepositado + (this.montoDepositado * interesTotal);
		return aux;
	}
	
	
}
