package ar.edu.unlp.info.oo1.ejercicio20_LiquidacionDeHaberes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
	private String nombre;
	private String apellido;
	private int CUIL;
	private LocalDate fechaNacimiento;
	private boolean tieneHijos;
	private boolean tieneConyuge;
	private Contrato contratoActivo;
	private List <Contrato> contratosVencidos;
	
	public Empleado (String nombre, String apellido, int CUIL, 
						LocalDate fechaDeNacimiento, boolean tieneHijos, Contrato contrato) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.CUIL = CUIL;
		this.fechaNacimiento = fechaNacimiento;
		this.tieneHijos = tieneHijos;
		this.contratosVencidos = new ArrayList ();
		this.contratoActivo = contrato;
	}
	
	private void agregarContratoVencido (Contrato contratoVencido) {
		this.contratosVencidos.add(contratoVencido);
	}
	
	public boolean nuevoContrato (Contrato contrato) {
		if (this.contratoActivo.esActivo()) {
			return false;
		}
		this.agregarContratoVencido(this.contratoActivo);
		this.contratoActivo = contrato;
		return true;
	}
	
	private int calcularAntiguedad () {
		return this.contratosVencidos
				.stream()
				.mapToInt(contrato -> contrato.calcularDuracion())
				.sum();
	}

	private double calcularMontoACobrar () {
		double sueldoBasico = this.contratoActivo.calcularSueldoBasico();
		if ( this.calcularAntiguedad() >= 5 && this.calcularAntiguedad() < 10 ) {
			return sueldoBasico * 1.30;
		}
		else if (this.calcularAntiguedad() < 15) {
			return sueldoBasico * 1.50;
		}
		else if (this.calcularAntiguedad() < 20) {
			return sueldoBasico * 1.70;
		}
		return sueldoBasico * 2;
	}

	public ReciboDeSueldo generarReciboDeSueldo () {
		return new ReciboDeSueldo (this.nombre, this.apellido, this.CUIL,
									this.calcularAntiguedad(), this.calcularMontoACobrar());
	}
	
}
