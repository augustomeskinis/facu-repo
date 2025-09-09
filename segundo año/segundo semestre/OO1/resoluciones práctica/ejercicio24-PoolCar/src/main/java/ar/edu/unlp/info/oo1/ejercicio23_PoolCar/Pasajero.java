package ar.edu.unlp.info.oo1.ejercicio23_PoolCar;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Pasajero extends Usuario {
	private LocalDate fechaUltimoViaje;
	
	public Pasajero(String nombre, double saldo,LocalDate fechaUltimoViaje) {
		super(nombre, saldo);
		this.fechaUltimoViaje = fechaUltimoViaje;
	}
	
	public boolean saldoEnRojo () {
		if(this.saldo < 0) {
			return true;
		}
		return false;
	}
	
	private double comision(double monto) {
		if (this.fechaUltimoViaje == null) {
			return monto *  0.1;
		}
		int dias = (int) ChronoUnit.DAYS.between(fechaUltimoViaje, LocalDate.now());
		if  (dias > 30) {
			return monto * 0.1;
		}
		return 0;
	}
	
	public void cargarSaldo(double monto) {
		this.saldo += monto - this.comision(monto);
	}
	
	public int bonificacion () {
		if(this.fechaUltimoViaje != null) {
			return 500;
		}
		return 0;
	}
	
	
	public void descontarSaldo (double monto) {
		this.saldo -= monto;
		this.saldo += this.bonificacion(); 
	}
	
	
}
