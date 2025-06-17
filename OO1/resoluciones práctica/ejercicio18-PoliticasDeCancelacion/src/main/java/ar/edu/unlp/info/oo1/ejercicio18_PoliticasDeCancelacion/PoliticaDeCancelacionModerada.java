package ar.edu.unlp.info.oo1.ejercicio18_PoliticasDeCancelacion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PoliticaDeCancelacionModerada implements PoliticaDeCancelacion {

	
	public double reembolsar (LocalDate fecha,double monto){
		if (ChronoUnit.DAYS.between(LocalDate.now(), fecha) <= 2) {
			return monto * 0.50;
		}
		return 0;
	}
}
