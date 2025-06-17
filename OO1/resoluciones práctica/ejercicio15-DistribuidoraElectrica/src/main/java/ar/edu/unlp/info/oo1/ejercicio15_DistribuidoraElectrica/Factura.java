package ar.edu.unlp.info.oo1.ejercicio15_DistribuidoraElectrica;
 
import java.time.LocalDate;

public class Factura {
	private LocalDate fecha;
	private double montoFinal;
	private boolean bonificacion;
	private Usuario usuario;
	
	public Factura (Usuario usuario, boolean bonificacion, double montoFinal) {
		fecha = LocalDate.now();
		this.usuario = usuario;
		this.bonificacion=bonificacion;
		this.montoFinal=montoFinal;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public double getMontoFinal() {
		return montoFinal;
	}

	public boolean isBonificacion() {
		return bonificacion;
	}

}
