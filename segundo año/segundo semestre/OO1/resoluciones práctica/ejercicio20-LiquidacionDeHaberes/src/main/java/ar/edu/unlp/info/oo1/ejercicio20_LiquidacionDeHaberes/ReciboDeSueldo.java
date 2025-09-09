package ar.edu.unlp.info.oo1.ejercicio20_LiquidacionDeHaberes;

import java.time.LocalDate;

public class ReciboDeSueldo {
	private LocalDate fechaCreacion;
	private String nombreEmpleado;
	private String apellidoEmpleado;
	private int CUILempleado;
	private int antiguedadEmpleado;
	private double montoACobrar;
	
	public ReciboDeSueldo(String nombreEmpleado, String apellidoEmpleado, int CUILempleado,
			int antiguedadEmpleado, double montoACobrar) {
		super();
		this.fechaCreacion = LocalDate.now();
		this.nombreEmpleado = nombreEmpleado;
		this.apellidoEmpleado = apellidoEmpleado;
		this.CUILempleado = CUILempleado;
		this.antiguedadEmpleado = antiguedadEmpleado;
		this.montoACobrar = montoACobrar;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public String getApellidoEmpleado() {
		return apellidoEmpleado;
	}

	public int getCUILempleado() {
		return CUILempleado;
	}

	public int getAntiguedadEmpleado() {
		return antiguedadEmpleado;
	}

	public double getMontoACobrar() {
		return montoACobrar;
	}
	

	
	
}
