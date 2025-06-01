package ar.edu.unlp.info.oo1.ejercicio3_presupuestos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
	private java.time.LocalDate Fecha;
	private String cliente;
	private List<Item> items; 
	
	public Presupuesto (String cliente) {
		this.cliente = cliente;
		this.Fecha = LocalDate.now();
		this.items = new ArrayList<Item>();
	}
	
	public void agregarItem (Item item) {
		items.add(item);
	}
	
	public double calcularTotal () {
		double aux = 0;
		for (Item I: items) {
			aux += I.costo();
		}
		return aux;
	}
	
	public java.time.LocalDate getFecha() {
		return this.Fecha;
	}
	
	public String getCliente() {
		return this.cliente;
	}
	
}
