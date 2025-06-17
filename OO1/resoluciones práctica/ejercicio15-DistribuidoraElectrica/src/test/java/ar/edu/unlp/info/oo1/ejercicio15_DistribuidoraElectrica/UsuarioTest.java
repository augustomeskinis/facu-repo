package ar.edu.unlp.info.oo1.ejercicio15_DistribuidoraElectrica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
	private Consumo consumo1;
	private Consumo consumo2;
	private Usuario usuario;
	private CuadroTarifario cuadroTarifario;
	
	@BeforeEach
	public void setUp() {
		this.consumo1 = new Consumo (10,15);
		this.consumo2 = new Consumo (2,15);
		this.usuario = new Usuario ("Augusto","15 n43");
		this.cuadroTarifario = new CuadroTarifario (3);
	}
	
	@Test
	public void testEmitirFactura() {
		Factura facturaDePrueba = new Factura (usuario,false,6);
		usuario.agregarConsumo(consumo1);
		usuario.agregarConsumo(consumo2); // va a trabajar con consumo 2 para hacer la factura
		Factura facturaDeUsuario = usuario.emitirFactura(cuadroTarifario);
		assertEquals(facturaDeUsuario.getFecha(),facturaDePrueba.getFecha());
		assertEquals(facturaDeUsuario.getMontoFinal(),facturaDePrueba.getMontoFinal());
		assertEquals(facturaDeUsuario.isBonificacion(),facturaDePrueba.isBonificacion());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
