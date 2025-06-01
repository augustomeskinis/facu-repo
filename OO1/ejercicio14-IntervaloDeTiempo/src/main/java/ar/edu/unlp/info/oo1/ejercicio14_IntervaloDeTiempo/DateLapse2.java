package ar.edu.unlp.info.oo1.ejercicio14_IntervaloDeTiempo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse2 {
	private LocalDate from;
	private int sizeInDays;
	
	public DateLapse2 (LocalDate from, LocalDate to) {
		this.from = from;
		this.sizeInDays = (int) ChronoUnit.DAYS.between(from, to);
	}
	
	public LocalDate getFrom () {
		return this.from;
	}
	
	public LocalDate getTo () {
		return this.from.plusDays(sizeInDays);
	}
	
	public int sizeInDays () {
		return this.sizeInDays;
	}
	
	public boolean includesDate (LocalDate fechaAComprobar) {
		return  ( fechaAComprobar.isAfter(this.from) || fechaAComprobar.isEqual(this.from) )
				&& (fechaAComprobar.isBefore(this.getTo()) || fechaAComprobar.isEqual(this.getTo()));
		
	}
	
	public boolean overLaps (DateLapse anotherDateLapse) {
		return this.includesDate(anotherDateLapse.getFrom()) || this.includesDate(anotherDateLapse.getTo());
	}
	
	
}



