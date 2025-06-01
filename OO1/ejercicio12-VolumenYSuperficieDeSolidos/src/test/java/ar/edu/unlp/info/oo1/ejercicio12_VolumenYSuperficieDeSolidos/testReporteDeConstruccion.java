package ar.edu.unlp.info.oo1.ejercicio12_VolumenYSuperficieDeSolidos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testReporteDeConstruccion {
	private ReporteDeConstruccion reporte;
	private Cilindro c;
	private Esfera e;
	private PrismaRectangular p;
	
	@BeforeEach
	public void setUp() {
		c = new Cilindro ("hierro","rojo",2,5);
		e = new Esfera ("hierro","rojo",2);
		p = new PrismaRectangular ("hierro","rojo",2,4,5);
	}
	
	
	@Test 
	public void testVolumen() {
		assertEquals(62,c.volumen());
		assertEquals(25,e.volumen());
		assertEquals(40,p.volumen());
	}
	
	@Test
	public void testSuperficie() {
		assertEquals(87,c.superficie());
		assertEquals(50,e.superficie());
		assertEquals(76,p.superficie());
	}
	
	@Test
	public void testVolumenDeMaterial() {
		reporte = new ReporteDeConstruccion();
		reporte.agregarPieza(c);
		reporte.agregarPieza(e);
		reporte.agregarPieza(p);
		Cilindro c2 = new Cilindro ("plata","verde",0,0);
		reporte.agregarPieza(c2);
		assertEquals(127,reporte.volumenDeMaterial("hierro"));
	}
	
	@Test
	public void testSuperficieDeColor() {
		reporte = new ReporteDeConstruccion();
		reporte.agregarPieza(c);
		reporte.agregarPieza(e);
		reporte.agregarPieza(p);
		Cilindro c2 = new Cilindro ("plata","verde",0,0);
		reporte.agregarPieza(c2);
		assertEquals(213,reporte.superficieDeColor("rojo"));
	}
	
	
	
	
	
}
