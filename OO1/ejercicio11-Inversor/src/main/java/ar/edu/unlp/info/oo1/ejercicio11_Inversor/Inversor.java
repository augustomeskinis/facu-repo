package ar.edu.unlp.info.oo1.ejercicio11_Inversor;

import java.util.List;
import java.util.ArrayList;
public class Inversor implements ValorActual {
	private String nombre;
	private List <ValorActual> inversiones;
	
	public Inversor(String unNombre) {
		inversiones = new ArrayList<ValorActual>();
		setNombre(unNombre);
	}
	
	public void agregarInversion(ValorActual unaInversion) {
		this.inversiones.add(unaInversion);
	}
	
	public double valorActual () {
		double aux=0;
		for(ValorActual I: inversiones) {
			aux+=I.valorActual();
		}
		return aux;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
	