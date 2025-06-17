package ar.edu.unlp.info.oo1.ejercicio11_Inversor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class testInversor {
	private Inversor i = new Inversor ("i");
	
	LocalDate f1 = LocalDate.of(2024, 10, 1); LocalDate f2 = LocalDate.of(2024, 10, 2);
	private PlazoFijo p1 = new PlazoFijo (f1,40000,0.01);
	private PlazoFijo p2 = new PlazoFijo (f2,50000,0.07);
	private InversionEnAcciones i1 = new InversionEnAcciones ("i1",20,50);
	private InversionEnAcciones i2 = new InversionEnAcciones ("i2",15,32.5);
	
	@Test
	public void testValorActual() {
		assertEquals(p1.valorActual(),40800);
		assertEquals(p2.valorActual(),53500);
		assertEquals(i1.valorActual(),1000);
		assertEquals(i2.valorActual(),487,5);
		System.out.println(p1.valorActual()); // Debería imprimir 40800
		System.out.println(p2.valorActual()); // Debería imprimir 53500
		System.out.println(i1.valorActual()); // Debería imprimir 1000
		System.out.println(i2.valorActual()); // Debería imprimir 487.5
		i.agregarInversion(p1);
		i.agregarInversion(p2);
		i.agregarInversion(i1);
		i.agregarInversion(i2);
		assertEquals(i.valorActual(),95787.5);

	}
	
	
	
	
	
}
