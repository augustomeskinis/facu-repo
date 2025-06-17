package ar.edu.unlp.info.oo1.ejercicio11_Inversor;

public class InversionEnAcciones implements ValorActual{
	String nombre;
	int cantidad;
	double valorUnitario;
	
	public InversionEnAcciones(String nombre, int cantidad, double valorUnitario) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.valorUnitario = valorUnitario;
	}
	
	public double valorActual() {
		return(this.cantidad * this.valorUnitario);
	}
}
