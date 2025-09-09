package ar.edu.unlp.info.oo1.ejercicio23_PoolCar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PasajeroTest {
	private Pasajero pasajeroSinUltimoViaje, pasajeroConViajeHace31Dias, pasajeroConViajeHace29Dias;
	@BeforeEach
	public void setUp () {
		this.pasajeroSinUltimoViaje = new Pasajero("augusto",0,null);
		this.pasajeroConViajeHace29Dias = new Pasajero ("juan",0,LocalDate.of(2024,10, 16));
		this.pasajeroConViajeHace31Dias = new Pasajero ("pepe",0,LocalDate.of(2024, 10, 14));
	}
	@Test
	public void testCargarSaldo () {
		pasajeroSinUltimoViaje.cargarSaldo(100);
		assertEquals(90,pasajeroSinUltimoViaje.getSaldo());
		pasajeroConViajeHace29Dias.cargarSaldo(100);
		assertEquals(100,pasajeroConViajeHace29Dias.getSaldo());
		pasajeroConViajeHace31Dias.cargarSaldo(100);
		assertEquals(90,pasajeroConViajeHace31Dias.getSaldo());
	}
	@Test
	public void testDescontarSaldo() {
		pasajeroSinUltimoViaje.descontarSaldo(100);
		assertEquals(-100,pasajeroSinUltimoViaje.getSaldo());
		pasajeroConViajeHace29Dias.descontarSaldo(100);
		assertEquals(400,pasajeroConViajeHace29Dias.getSaldo());
	}
	
	
	
}
