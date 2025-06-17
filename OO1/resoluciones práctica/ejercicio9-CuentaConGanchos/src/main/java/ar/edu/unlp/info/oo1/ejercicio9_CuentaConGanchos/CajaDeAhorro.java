package ar.edu.unlp.info.oo1.ejercicio9_CuentaConGanchos;

public class CajaDeAhorro extends Cuenta{

	
	private double dosPorciento (double monto) {
		return (monto * 0.02);
	}
	
	
	
	protected boolean puedeExtraer(double monto) {
		monto -= this.dosPorciento(monto);
		return ( (this.getSaldo() - monto) > 0) ;
	}
	
	@Override
	public void depositar (double monto) {
		monto -= this.dosPorciento(monto); 
		super.depositar(monto);
	}
	
	 
	
}