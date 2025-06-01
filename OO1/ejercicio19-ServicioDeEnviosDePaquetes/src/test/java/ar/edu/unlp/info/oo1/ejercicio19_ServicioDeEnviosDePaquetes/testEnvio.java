package ar.edu.unlp.info.oo1.ejercicio19_ServicioDeEnviosDePaquetes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class testEnvio {
	private EnvioInternacional envioInternacional;
	private EnvioInterurbano envioInterurbano;
	private EnvioLocal envioLocal;
	private LocalDate fecha = LocalDate.now();
	
	@Test
	public void testCostoLocal () {
		envioLocal = new EnvioLocal (fecha,"lp","lp",50,false);
		assertEquals(1000,envioLocal.costo());
		envioLocal = new EnvioLocal (fecha,"lp","bsas",50,true);
		assertEquals(1500,envioLocal.costo());
	}
	@Test
	public void testCostoInterurbano () {
		envioInterurbano = new EnvioInterurbano (fecha,"lp","bsas",50,99);
		assertEquals(1000,envioInterurbano.costo());
		envioInterurbano = new EnvioInterurbano (fecha,"lp","bsas",50,499);
		assertEquals(1250,envioInterurbano.costo());
		envioInterurbano = new EnvioInterurbano (fecha,"lp","bsas",50,501);
		assertEquals(1500,envioInterurbano.costo());
	}
	
	@Test
	public void testCostoInternacional () {
		envioInternacional = new EnvioInternacional(fecha,"arg","usa",999);
		assertEquals (50000,envioInternacional.costo());
		envioInternacional = new EnvioInternacional(fecha,"arg","usa",1000);
		assertEquals (60000,envioInternacional.costo());
	}
}
