package ar.edu.unlp.info.oo1.ejercicio12_VolumenYSuperficieDeSolidos;

public class Esfera extends Pieza {
	private int radio;
	
	public Esfera (String unMaterial, String unColor, int unRadio) {
		super(unMaterial,unColor);
		this.radio = unRadio;
	}

	
	public int volumen() {
		return (int) ((4/3)*Math.PI*(Math.pow(this.radio, 3)));
	}
	
	public int superficie() {
		return (int) (4*Math.PI*(Math.pow(this.radio, 2)));
	}
	
}
