package ar.edu.unlp.info.oo1.ejercicio23_PoolCar;

public class Conductor extends Usuario {
	private Vehiculo vehiculo;

	public Conductor(String nombre, double saldo, Vehiculo vehiculo) {
		super(nombre, saldo);
		this.vehiculo = vehiculo;
		this.vehiculo.registrarPasajero();
	}
	
	public void cargarSaldo (double monto) {
		this.saldo += monto - vehiculo.comisionConductor(monto);
	}
	
	public void descontarSaldo (double costo) {
		this.saldo -= costo;
		this.saldo += this.vehiculo.bonificacionConductor(costo);
	}
	
	
}
