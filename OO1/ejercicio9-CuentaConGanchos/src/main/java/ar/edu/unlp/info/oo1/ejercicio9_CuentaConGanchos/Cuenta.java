package ar.edu.unlp.info.oo1.ejercicio9_CuentaConGanchos;

public abstract class Cuenta {
	private double saldo = 0;
	
	public Cuenta () {
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void depositar (double monto) {
		this.saldo += monto;
	}
	
	protected void extraerSinControlar(double monto) {
		this.saldo -= monto;
	}
	
	protected abstract boolean puedeExtraer(double monto);
	
	public boolean extraer (double monto) {
		if(this.puedeExtraer(monto)) {
			this.extraerSinControlar(monto);
			return true;
		}
		return false;
	}
	
	
	public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
		if (this.puedeExtraer(monto)) {
			this.extraerSinControlar(monto);
			cuentaDestino.depositar(monto);
			return true;
		}
		return false;
	}
	
	
}
