package ar.edu.unlp.info.oo1.ejercicio9_CuentaConGanchos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class test {

	private CajaDeAhorro caja;
	private cuentaCorriente cuenta;
	@BeforeEach
	public void setUp() {
		caja = new CajaDeAhorro();
		cuenta = new cuentaCorriente();
	}

	@Test
	public void testDepositar() {
		assertEquals(0,cuenta.getSaldo());
		
		caja.depositar(100);
		cuenta.depositar(100);
		
		assertEquals(98,caja.getSaldo());
		assertEquals(100,cuenta.getSaldo());
	}

	@Test
	public void testExtraer() {
		caja.depositar(100);
		assertEquals(true,caja.extraer(98));
		cuenta.depositar(100);
		cuenta.setDescubierto(50);
		assertEquals(true,cuenta.extraer(150));
		cuenta.depositar(150);
		assertEquals(false,cuenta.extraer(151));
	}
	
	@Test
	public void testTransferir() {
		caja.depositar(100);
		assertEquals(true,caja.transferirACuenta(98, cuenta));
		caja.depositar(100);
		assertEquals(98,cuenta.getSaldo());
		assertEquals(false,caja.transferirACuenta(100, cuenta));
		
		cuenta.depositar(100);
		assertEquals(true,cuenta.transferirACuenta(198, caja)); // 100 + 50 (descuebierto)
																// + 48 de la transferencia
	}
	
	
}