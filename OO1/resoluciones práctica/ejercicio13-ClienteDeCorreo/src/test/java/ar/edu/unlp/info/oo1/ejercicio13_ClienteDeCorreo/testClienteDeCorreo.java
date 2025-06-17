package ar.edu.unlp.info.oo1.ejercicio13_ClienteDeCorreo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testClienteDeCorreo {
	private Archivo a1;
	private Archivo a2;
	private Email e1;
	private Email e2;
	private Carpeta c1;
	private Carpeta c2;
	private ClienteDeCorreo cli;
	
	@BeforeEach
	public void setUp() {
		a1 = new Archivo("archivooo");
		a2 = new Archivo("archivooooooo");
		e1 = new Email("primer email", "buenos dias");
		e2 = new Email("segundo email", "buenas tardess");
		c1 = new Carpeta("primer carpeta");
		c2 = new Carpeta("segunda carpeta");
		cli = new ClienteDeCorreo();
		
	}
	@Test
	public void testBuscar() {
		this.cli.recibir(e1);
		this.cli.recibir(e2);
		assertEquals(e1,cli.buscar("primer email"));
		assertEquals(e2,cli.buscar("buenas tardess"));
	}
	
	@Test
	public void testEspacioOcupado() {
		this.e1.añadirArchivo(a1);
		this.e2.añadirArchivo(a2);
		this.cli.recibir(e1);
		this.cli.recibir(e2);
		// a1=9, a2=13, e1= 32, e2= 40, cli = e1 + e2 = 72
		assertEquals(72,cli.espacioOcupado());
	}
	
	
}
