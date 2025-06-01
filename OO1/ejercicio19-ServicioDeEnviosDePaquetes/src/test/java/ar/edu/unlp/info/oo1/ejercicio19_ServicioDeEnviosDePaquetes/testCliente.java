package ar.edu.unlp.info.oo1.ejercicio19_ServicioDeEnviosDePaquetes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testCliente {
	private ClienteCorporativo clienteCorporativo;
	private PersonaFisica personaFisica;
	private EnvioLocal envioLocal;
	private EnvioInterurbano envioInterurbano;
	private EnvioInternacional envioInternacional;
	private LocalDate fecha;
	
	@BeforeEach
	public void setUp () {
		envioLocal = new EnvioLocal (fecha.of(2024, 1, 1),"lp","bsas",50,true);
		envioInterurbano = new EnvioInterurbano (fecha.of(2024, 1, 1),"lp","bsas",50,99);
		envioInternacional = new EnvioInternacional(fecha.of(2024,1,5),"arg","usa",999);
	}
	
	@Test
	public void testCalcularMontoClienteCorporativo() {
		clienteCorporativo = new ClienteCorporativo("juan","citybell",2046345401);
		clienteCorporativo.agregarEnvio(envioLocal); // 1500
		clienteCorporativo.agregarEnvio(envioInterurbano); // 1000
		clienteCorporativo.agregarEnvio(envioInternacional); // 50000
		LocalDate fecha1 = LocalDate.of(2024, 1, 1);
		LocalDate fecha2 = LocalDate.of(2024, 1, 30);
		assertEquals(52500,clienteCorporativo.calcularMonto(fecha1, fecha2)); // 1000 + 1000 + 50000
		clienteCorporativo = new ClienteCorporativo("juan","citybell",2046345401);
		clienteCorporativo.agregarEnvio(envioLocal); // 1500
		clienteCorporativo.agregarEnvio(envioInterurbano); // 1000
		assertEquals(2500,clienteCorporativo.calcularMonto(fecha1, fecha2)); // 1000 + 1000
	}
	
	public void testCalcularMontoPersonaFisica () {
		personaFisica = new PersonaFisica(46345400,"juan","citybell");
		personaFisica.agregarEnvio(envioInternacional); // 50000
		personaFisica.agregarEnvio(envioInterurbano); //1000
		personaFisica.agregarEnvio(envioLocal); //1500
		LocalDate fecha1 = LocalDate.of(2024, 1, 1);
		LocalDate fecha2 = LocalDate.of(2024, 1, 30);
		assertEquals(47250, personaFisica.calcularMonto(fecha1, fecha2));
	}
	
	
	
}
