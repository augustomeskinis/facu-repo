package ar.edu.unlp.info.oo1.ejercicio14_IntervaloDeTiempo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDateLapse {
	private LocalDate from;
	private LocalDate to;
	private DateLapse2 Dlapse;
	
	
	@BeforeEach
	public void setUp () {
		from = LocalDate.of(2005, 02, 25);
		to = LocalDate.of(2020, 02, 25);
		Dlapse = new DateLapse2 (from,to);
		
	}
	
	
	@Test
	public void testSizeInDays() {
		assertEquals(5478, Dlapse.sizeInDays());
	}
	
	@Test
	public void testIncludesDate() {
		LocalDate fechaRandom = LocalDate.of(2010, 02, 25);
		assertTrue(Dlapse.includesDate(fechaRandom));
		fechaRandom = LocalDate.of(2005, 02, 25);
		assertTrue(Dlapse.includesDate(fechaRandom));
		fechaRandom = LocalDate.of(2020, 02, 25);
		assertTrue(Dlapse.includesDate(fechaRandom));
		fechaRandom = LocalDate.of(2005, 02, 24);
		assertFalse(Dlapse.includesDate(fechaRandom));
		fechaRandom = LocalDate.of(2020, 02, 26);
		assertFalse(Dlapse.includesDate(fechaRandom));
	}
	
}
