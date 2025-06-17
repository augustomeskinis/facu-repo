package ar.edu.unlp.info.oo1.ejercicio4_balanzaMejorada;

import java.time.LocalDate;
import java.util.List;

public class Ticket {
	private java.time.LocalDate fecha = LocalDate.now();
	private int cantProductos;
	private double pesoTotal;
	private double precioTotal;
	
	public Ticket (List<Producto> productos) {
		for (Producto P: productos) {
			cantProductos++;
			pesoTotal+=P.getPeso();
			precioTotal+=P.getPrecio();
		}
	}
	
	public double impuesto() {
		return (this.precioTotal * 100 /21);
	}
	
	public String toString () {
		return ("cantidad de productos: " + this.cantProductos + "\n" +
				"peso total: " + this.pesoTotal + "\n" +
				"precio total: " + this.precioTotal + "\n" +
				"impuesto: " + this.impuesto() + "\n" +
				"precio más impuesto: " + (this.precioTotal + this.impuesto())
				);	
	}

	public java.time.LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(java.time.LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getCantidadDeProductos() {
		return cantProductos;
	}

	public void setCantProductos(int cantProductos) {
		this.cantProductos = cantProductos;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
}
