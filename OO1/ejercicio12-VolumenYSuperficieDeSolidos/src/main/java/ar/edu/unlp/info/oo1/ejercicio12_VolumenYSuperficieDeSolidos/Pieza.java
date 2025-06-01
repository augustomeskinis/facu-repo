package ar.edu.unlp.info.oo1.ejercicio12_VolumenYSuperficieDeSolidos;

public abstract class Pieza {
	protected String material;
	protected String color;
	
	public Pieza (String unMaterial, String unColor) {
		this.material = unMaterial;
		this.color = unColor;
	}
	
	public abstract int volumen();
	public abstract int superficie();

}
