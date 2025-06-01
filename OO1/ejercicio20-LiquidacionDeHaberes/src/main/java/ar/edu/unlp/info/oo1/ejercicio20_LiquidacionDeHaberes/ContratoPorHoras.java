package ar.edu.unlp.info.oo1.ejercicio20_LiquidacionDeHaberes;

import java.time.LocalDate;

public class ContratoPorHoras extends Contrato{
	private double valorHora;
	private double horasPorMes;
	
	
	public ContratoPorHoras (LocalDate fechaInicio,LocalDate fechaFin, double valorHora,
								double horasPorMes) {
		super(fechaInicio,fechaFin);
		this.valorHora = valorHora;
		this.horasPorMes = horasPorMes;		
	}
	
	
	public double calcularSueldoBasico () {
		return this.valorHora * this.horasPorMes ;
	}


}
