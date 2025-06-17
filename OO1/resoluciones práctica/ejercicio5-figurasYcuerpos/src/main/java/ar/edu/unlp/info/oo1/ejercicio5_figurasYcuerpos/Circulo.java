package ar.edu.unlp.info.oo1.ejercicio5_figurasYcuerpos;

public class Circulo implements Figura {
	private double diametro;
	private double radio;
	
	
	public double getArea() {
		return(Math.PI*Math.sqrt(this.radio));
	}
	
	public double getPerimetro() {
		return (Math.PI*this.diametro);
	}
	
	
	public double getDiametro() {
		return diametro;
	}

	public void setDiametro(double radio) {
		this.diametro = (radio*2);
	}


	public double getRadio() {
		return radio;
	}

	public void setRadio (double radio) {
		this.radio = radio;
	}
	
	
	
}
