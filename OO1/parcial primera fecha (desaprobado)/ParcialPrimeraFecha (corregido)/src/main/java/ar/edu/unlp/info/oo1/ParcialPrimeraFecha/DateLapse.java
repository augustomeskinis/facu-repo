package ar.edu.unlp.info.oo1.ParcialPrimeraFecha;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class DateLapse {
	private LocalDate from;
	private LocalDate to;
	
	
	public DateLapse (LocalDate unFrom, LocalDate unTo) {
		this.from = unFrom;
		this.to = unTo;
	}


	public LocalDate getFrom() {
		return from;
	}


	public LocalDate getTo() {
		return to;
	}
	
	public int sizeInDays() {
		return (int) (ChronoUnit.DAYS.between(from, to));
	}
	
	public boolean includesDate(LocalDate fechaAComprobar) {
		return (fechaAComprobar.isAfter(this.from) || fechaAComprobar.isEqual(this.from)) &&
                (fechaAComprobar.isBefore(this.to) || fechaAComprobar.isEqual(this.to));
	}
	
	public boolean overlaps (DateLapse anotherDateLapse) {
		return this.includesDate(anotherDateLapse.getFrom()) || this.includesDate(anotherDateLapse.getTo()) ;
	}
	
}
