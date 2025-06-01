package ar.edu.unlp.info.oo1.ejercicio12_VolumenYSuperficieDeSolidos;

public class PrismaRectangular extends Pieza {
	private int ladoMayor;
	private int ladoMenor;
	private int altura;
	
	public PrismaRectangular(String unMaterial, String unColor,
								int unLadoMayor,int unLadoMenor, int unaAltura) {
		super(unMaterial,unColor);
		this.ladoMayor = unLadoMayor;
		this.ladoMenor = unLadoMenor;
		this.altura = unaAltura;
	}
	
	public int volumen() {
		return(this.ladoMayor*this.ladoMenor*this.altura);
	}
	
	public int superficie() {
		return(2*((this.ladoMayor*this.ladoMenor)+ (this.ladoMayor*this.altura) + (this.ladoMenor *this.altura)));
	}
}
