package ar.edu.unlp.info.oo1.ejercicio23_PoolCar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConductorTest {
	private Conductor conductor1, conductor2;
	private Vehiculo vehiculoViejo, vehiculoNuevo;
	@BeforeEach
	public void setUp() {
		this.vehiculoViejo = new Vehiculo ("",5,2019,100);
		this.vehiculoNuevo = new Vehiculo ("",5,2020,100);
		this.conductor1= new Conductor ("juan",0,vehiculoViejo);
		this.conductor2 = new Conductor ("pepe",0,vehiculoNuevo);
	}
	
	@Test
	public void testCargarSaldo() {
		this.conductor1.cargarSaldo(100);
		assertEquals(90,conductor1.getSaldo());
		this.conductor2.cargarSaldo(100);
		assertEquals(99,conductor2.getSaldo());
	}
}
