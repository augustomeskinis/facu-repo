package ar.edu.unlp.info.oo1.ejercicio12_VolumenYSuperficieDeSolidos;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {
	private List <Pieza> piezas;
	
	public ReporteDeConstruccion () {
		piezas = new ArrayList<Pieza>();
	}
	
	public void agregarPieza(Pieza P) {
		piezas.add(P);
	}
	
	public int volumenDeMaterial(String unMaterial) {
		int aux = piezas.stream().filter(pieza -> pieza.material.equals(unMaterial)).mapToInt
					(pieza -> pieza.volumen()).sum();
		return aux;
	}
	
	public int superficieDeColor(String unColor) {
		int aux  = piezas.stream().filter(pieza -> pieza.color.equals(unColor)).mapToInt
				(pieza -> pieza.superficie()).sum();
		return aux;
	}
	
	
}
