package ar.edu.unlp.info.oo1.ejercicio20_LiquidacionDeHaberes;
import java.time.LocalDate;

public class ContratoDePlanta extends Contrato {
	private double sueldoMensual;
	private double montoPorConyuge;
	private double montoPorHijos;
	
	
	public ContratoDePlanta (LocalDate fechaInicio, LocalDate fechaFin, double sueldoMensual,
						double montoPorConyuge, double montoPorHijos) {
		super(fechaInicio,fechaFin);
		this.sueldoMensual = sueldoMensual;
		this.montoPorConyuge = montoPorConyuge;
		this.montoPorHijos = montoPorHijos;
		
	}
	
	
	public double calcularSueldoBasico () {
		return this.sueldoMensual + this.montoPorConyuge + this.montoPorHijos ;
	}
	
	
	
	
	
}
