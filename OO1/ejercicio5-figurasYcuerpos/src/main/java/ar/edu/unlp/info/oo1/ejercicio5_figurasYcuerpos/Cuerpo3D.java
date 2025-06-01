package ar.edu.unlp.info.oo1.ejercicio5_figurasYcuerpos;

public class Cuerpo3D {
	private double altura;
	private Figura caraBasal;
	
	public double getVolumen() {
		return (this.caraBasal.getArea() * this.altura);
	}
	
	public double getSuperficieExterior() {
		return ((2*this.caraBasal.getArea())+(this.caraBasal.getPerimetro()*this.altura));
	}
	
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public void setCaraBasal(Figura caraBasal) {
		this.caraBasal = caraBasal;
	}
	
	
	
	
	
	
	
}
