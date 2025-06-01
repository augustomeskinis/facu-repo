package ar.edu.unlp.info.oo1.ejercicio21_Bag;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class testMap {
	private Map<String, Integer> mapa = new HashMap<>();

	@Test
	public void testMapa() {
		mapa.put("Lionel Messi", 111);
		mapa.put("Gabriel Batistuta", 56);
		mapa.put("Kun Aguero", 42);
		mapa.remove("Kun Aguero");
		mapa.replace("Lionel Messi",112);
		mapa.put("Gabriel Batistuta", 0);
		assertEquals(112,mapa.values().stream().mapToInt(Integer::intValue).sum());
	}
}
