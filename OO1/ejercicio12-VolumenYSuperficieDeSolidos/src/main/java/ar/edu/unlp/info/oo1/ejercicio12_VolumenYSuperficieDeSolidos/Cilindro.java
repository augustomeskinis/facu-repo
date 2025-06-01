package ar.edu.unlp.info.oo1.ejercicio12_VolumenYSuperficieDeSolidos;

public class Cilindro extends Pieza{
	private int radio;
	private int altura;
	
	public Cilindro (String unMaterial, String unColor, int unRadio,int unaAltura) {
		super(unMaterial,unColor);
		this.radio = unRadio;
		this.altura = unaAltura;
	}
	
	public int volumen() {
		return (int) ( Math.PI * (Math.pow(this.radio, 2)) * this.altura );
	}
	
	public int superficie() {
		return (int) ( (2*Math.PI*this.radio*this.altura) + (2*Math.PI*(Math.pow(this.radio, 2))));
	}
}
