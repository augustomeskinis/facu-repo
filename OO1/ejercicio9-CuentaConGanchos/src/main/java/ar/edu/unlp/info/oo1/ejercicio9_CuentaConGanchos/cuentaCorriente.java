package ar.edu.unlp.info.oo1.ejercicio9_CuentaConGanchos;

public class cuentaCorriente extends Cuenta {
	private double descubierto;
	
	public cuentaCorriente() {
		this.descubierto = 0;
	}

	public double getDescubierto() {
		return descubierto;
	}

	public void setDescubierto(double descubierto) {
		this.descubierto = 0 - descubierto;
	}
	
	protected boolean puedeExtraer(double monto) {
		return ( ( this.getSaldo() - monto ) >= this.getDescubierto()) ;
	}
	
}
