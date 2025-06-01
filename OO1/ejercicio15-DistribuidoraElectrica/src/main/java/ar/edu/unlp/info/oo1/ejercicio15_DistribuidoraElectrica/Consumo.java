package ar.edu.unlp.info.oo1.ejercicio15_DistribuidoraElectrica;

public class Consumo {
	private double activa;
	private double reactiva;
	
	public Consumo(double unaActiva, double unaReactiva) {
		this.setActiva(unaActiva);
		this.setReactiva(unaReactiva);
	}

	public double factorDePotencia() {
		return this.activa / (Math.sqrt( Math.pow(this.activa, 2) + Math.pow(this.reactiva, 2)));
	}
	
	public double costo(double precioKWH) {
		return this.activa*precioKWH;
	}
	
	public double getActiva() {
		return activa;
	}

	public void setActiva(double activa) {
		this.activa = activa;
	}
	
	public double getReactiva() {
		return reactiva;
	}

	public void setReactiva(double reactiva) {
		this.reactiva = reactiva;
	}
}