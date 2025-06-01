package ar.edu.unlp.info.oo1.ParcialPrimeraFecha;

public class Sede {
	private String nombre;
	private double precioEstadia;
	private int diasEstadia;
	public Sede(String nombre, double precioEstadia, int diasEstadia) {
		super();
		this.nombre = nombre;
		this.precioEstadia = precioEstadia;
		this.diasEstadia = diasEstadia;
	}
	
	public double precioTotal () {
		return this.precioEstadia * this.diasEstadia;
	}
	
}
