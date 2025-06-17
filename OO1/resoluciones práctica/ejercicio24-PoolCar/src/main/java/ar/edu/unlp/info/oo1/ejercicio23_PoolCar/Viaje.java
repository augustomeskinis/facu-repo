package ar.edu.unlp.info.oo1.ejercicio23_PoolCar;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Viaje {
	private String origen;
	private String destino;
	private double costoTotal;
	private LocalDate fecha;
	private Vehiculo vehiculo;
	private Conductor conductor;
	private List <Pasajero> pasajeros;
	
	
	public Viaje (String origen, String destino, double costoTotal, LocalDate fecha, Vehiculo vehiculo,
					Conductor conductor) {
		this.origen = origen;
		this.destino = destino;
		this.costoTotal = costoTotal;
		this.fecha = fecha;
		this.conductor = conductor;
		this.vehiculo = vehiculo;
		this.pasajeros = new ArrayList <Pasajero>();
	}
	
	public boolean registrarPasajero (Pasajero pasajero) {
		int diasAntes = (int) ChronoUnit.DAYS.between(LocalDate.now(), fecha);
		
		if (vehiculo.registrarPasajero() && (diasAntes > 2) && ! pasajero.saldoEnRojo()) {
			this.pasajeros.add(pasajero);
			return true;
		}
		return false;
	}
	
	public void procesarViaje () {
		int cantidadPasajeros = this.pasajeros.size() + 1; // pasajeros + conductor
		double montoADescontar = this.costoTotal / cantidadPasajeros;
		this.conductor.descontarSaldo(montoADescontar);
		this.pasajeros.stream().forEach(pasajero -> pasajero.descontarSaldo(montoADescontar));
	}

}
