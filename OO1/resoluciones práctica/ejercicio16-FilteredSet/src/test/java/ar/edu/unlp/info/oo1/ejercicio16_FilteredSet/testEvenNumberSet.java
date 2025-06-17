package ar.edu.unlp.info.oo1.ejercicio16_FilteredSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testEvenNumberSet {
	private Set<Integer> numbers;
	
	@BeforeEach
	public void setUp() {
		numbers = new EvenNumberSet();
	}
	
	@Test
	public void testAdd() {
		assertEquals(false,numbers.add(1)); // No es par, entonces no se agrega => []
		assertEquals(true,numbers.add(2)); // Es par, se agrega al set => [2]
		assertEquals(true,numbers.add(4)); // Es par, se agrega al set => [2, 4]
		assertEquals(false,numbers.add(2)); // Es par, pero ya está en el set, no se agrega => [2, 4]
	}
	
	
}
