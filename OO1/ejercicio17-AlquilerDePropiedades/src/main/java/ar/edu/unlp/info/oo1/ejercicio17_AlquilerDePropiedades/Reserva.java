package ar.edu.unlp.info.oo1.ejercicio17_AlquilerDePropiedades;

public class Reserva {
	private DateLapse dateLapse;
	private Usuario usuario;
	
	public Reserva (Usuario usuario, DateLapse dateLapse) {
		this.usuario = usuario;
		this.dateLapse = dateLapse;
	}

	public DateLapse getDateLapse() {
		return dateLapse;
	}
	
	public boolean overlaps (DateLapse dateLapse) {
		return (this.dateLapse.overlaps(dateLapse));
	}
	
	public double calcularPrecio (double precioPorNoche) {
		return (precioPorNoche * this.dateLapse.sizeInDays());
	}
	
}