package ar.edu.unlp.info.oo1.ejercicio15_DistribuidoraElectrica;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConsumoTest {
	private double energiaActiva;
	private double energiaReactiva;
	private Consumo consumo;
	
	@BeforeEach
	public void setUp() {
		this.energiaActiva = 10;
		this.energiaReactiva = 15;
		this.consumo = new Consumo (this.energiaActiva,this.energiaReactiva);
	}
	
	@Test
	public void testFactorDePotencia() {
		assertEquals(0.554700196225229122018341733457,this.consumo.factorDePotencia());
	}
	
	
	
}
