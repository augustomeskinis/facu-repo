package ar.edu.unlp.info.oo1.ejercicio23_PoolCar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ViajeTest {

	private Viaje viajeConTiempo,viajeEn1Dia,viajeEn2Dias,viajeEn3Dias, viajeConCapacidad, viajeSinCapacidad;
	private Pasajero pasajeroConSaldo, pasajeroConSaldoEnRojo;
	private Vehiculo vehiculo, vehiculoSinCapacidad, vehiculoConCapacidad;
	private Conductor conductor;
	
	@BeforeEach
	public void setUp () {
		
		this.pasajeroConSaldo = new Pasajero ("augusto",500,null);
		this.pasajeroConSaldoEnRojo = new Pasajero ("augusto",-500, null);
		
		
		this.vehiculoConCapacidad = new Vehiculo ("",2,0,0);
		this.vehiculoSinCapacidad = new Vehiculo ("",0,0,0);
		this.vehiculo = new Vehiculo ("",500,1990,100);
		
		this.conductor = new Conductor ("carlos",500,vehiculo);

		this.viajeConTiempo = new Viaje ("lp","bariloche",500,LocalDate.of(2026, 1, 1),vehiculo,conductor);
		this.viajeEn1Dia = new Viaje ("lp","bariloche",500,LocalDate.of(2024, 11, 15),vehiculo,conductor);
		this.viajeEn2Dias = new Viaje ("lp","bariloche",500,LocalDate.of(2024, 11, 16),vehiculo,conductor);
		this.viajeEn3Dias = new Viaje ("lp","bariloche",500,LocalDate.of(2024, 11, 17),vehiculo,conductor);
		this.viajeConCapacidad = new Viaje ("lp","bariloche",500,LocalDate.of(2026, 1, 1),vehiculoConCapacidad,conductor);
		this.viajeSinCapacidad = new Viaje ("lp","bariloche",500,LocalDate.of(2026, 1, 1),vehiculoSinCapacidad,conductor);
	}
	@Test
	public void testRegistrarPasajero () {
		assertEquals(true, this.viajeConTiempo.registrarPasajero(pasajeroConSaldo));
		assertEquals(false, this.viajeConTiempo.registrarPasajero(pasajeroConSaldoEnRojo));
		assertEquals(true,this.viajeEn3Dias.registrarPasajero(pasajeroConSaldo));
		assertEquals(false,this.viajeEn2Dias.registrarPasajero(pasajeroConSaldo));
		assertEquals(false,this.viajeEn2Dias.registrarPasajero(pasajeroConSaldo));
		assertEquals(true,this.viajeConCapacidad.registrarPasajero(pasajeroConSaldo));
		assertEquals(false,this.viajeSinCapacidad.registrarPasajero(pasajeroConSaldo));
		
	}
	@Test
	public void testProcesarViaje () {
		this.viajeConTiempo.registrarPasajero(pasajeroConSaldo);
		this.viajeConTiempo.procesarViaje();
		assertEquals(251,this.conductor.getSaldo());
		assertEquals(250,this.pasajeroConSaldo.getSaldo());
	}
	
	
	
	
}
