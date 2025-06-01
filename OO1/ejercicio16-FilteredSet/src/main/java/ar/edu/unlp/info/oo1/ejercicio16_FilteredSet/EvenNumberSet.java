package ar.edu.unlp.info.oo1.ejercicio16_FilteredSet;

import java.util.HashSet;

public class EvenNumberSet extends HashSet<Integer>{


	public boolean add (Integer numero) {
		if (numero % 2 == 0) {
			return super.add(numero);
		}
	return false;
	}
	
}
