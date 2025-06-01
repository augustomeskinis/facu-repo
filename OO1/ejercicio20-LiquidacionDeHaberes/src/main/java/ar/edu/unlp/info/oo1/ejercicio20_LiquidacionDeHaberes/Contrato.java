package ar.edu.unlp.info.oo1.ejercicio20_LiquidacionDeHaberes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Contrato {
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	
	public Contrato (LocalDate fechaInicio, LocalDate fechaFin) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	
	public abstract double calcularSueldoBasico();
	
	public boolean esActivo() {
	        return fechaFin == null || fechaFin.isAfter(LocalDate.now());
	   }
	
	public int calcularDuracion () {
		return (int) ChronoUnit.YEARS.between(fechaInicio, fechaFin) ;
	}
	
}
