package ar.edu.unlp.info.oo1.ejercicio23_PoolCar;

public class Vehiculo {
	private String descripcion;
	private int capacidad;
	private int añoFabricacion;
	private int valorMercado;
	
	public Vehiculo(String descripcion, int capacidad, int añoFabricacion, int valorMercado) {
		super();
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.añoFabricacion = añoFabricacion;
		this.valorMercado = valorMercado;
	}

	public boolean registrarPasajero () {
		if (this.capacidad > 0) {
			this.capacidad--;
			return true;
		}
		return false;
	}
	
	public double comisionConductor (double monto) {
		if (2024 - this.añoFabricacion < 5) {
			return monto*0.01;
		}
		return monto * 0.1;
	}
	
	public double bonificacionConductor (double monto) {
		return this.valorMercado * 0.01;
	}
	
	
	
	
}
