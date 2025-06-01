package ar.edu.unlp.info.oo1.ParcialPrimeraFecha;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Entrada {
	private boolean reembolso;
	private LocalDate fecha;
	private Evento evento;
	
	public Entrada(boolean reembolso,Evento evento) {
		super();
		this.reembolso = reembolso;
		this.fecha = LocalDate.now();
		this.evento = evento;
	}
	
	public double precioEntrada () {
		return this.evento.consultarPrecio(fecha);
	}
	
	public boolean estaIntervalo (DateLapse dateLapse) {
		return dateLapse.includesDate(fecha);
	}
	
	public LocalDate getFecha () {
		return this.fecha;
	}
	
	public double calcularMontoARetornar() {
	    double precioActual = this.evento.consultarPrecio(LocalDate.now()); // Precio actual del evento
	    int diasEntre = (int) ChronoUnit.DAYS.between(fecha, evento.getFecha());

	    // Caso: 30 días o más
	    if (diasEntre >= 30) {
	        return (precioActual * 0.50) + this.calcularSeguro(precioActual);
	    }

	    // Caso: Menos de 30 días
	    return this.calcularSeguro(precioActual);
	}

	private double calcularSeguro(double precioActual) {
	    if (this.reembolso) {
	        return precioActual * 0.15;
	    }
	    return 0;
	}
	
}
