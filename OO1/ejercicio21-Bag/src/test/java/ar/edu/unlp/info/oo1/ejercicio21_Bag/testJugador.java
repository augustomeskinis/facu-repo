package ar.edu.unlp.info.oo1.ejercicio21_Bag;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class testJugador {
	private Map <Jugador, Integer> golesPorJugador = new HashMap <> ();
	
	@Test
	public void testMapa () {
		Jugador LionelMessi = new Jugador ("Lionel","Messi");
		this.golesPorJugador.put(LionelMessi, 111);
		Jugador GabrielBatistuta = new Jugador ("Gabriel","Batistuta");
		this.golesPorJugador.put(GabrielBatistuta, 56);
		Jugador KunAguero = new Jugador ("Kun","Aguero");
		this.golesPorJugador.put(KunAguero, 42);
		this.golesPorJugador.replace(LionelMessi, 112);
		this.golesPorJugador.put(GabrielBatistuta, 0);
		this.golesPorJugador.remove(KunAguero);
		assertEquals(112,this.golesPorJugador.values().stream().mapToInt(Integer::intValue).sum());
	}
	
}
