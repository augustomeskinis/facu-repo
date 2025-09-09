package ar.edu.unlp.info.oo1.ejercicio18_PoliticasDeCancelacion;

import java.time.LocalDate;

public class PoliticaDeCancelacionFlexible implements PoliticaDeCancelacion {

	public double reembolsar (LocalDate fecha,double monto) {
		if (fecha.isAfter(LocalDate.now())) {
			return monto;
		}
		return 0;
	}
	
}
