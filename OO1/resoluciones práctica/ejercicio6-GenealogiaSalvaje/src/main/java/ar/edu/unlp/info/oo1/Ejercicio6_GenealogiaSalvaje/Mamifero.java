package ar.edu.unlp.info.oo1.Ejercicio6_GenealogiaSalvaje;

import java.util.Date;

public class Mamifero {
	private String identificador;
	private String especie;
	private Date fechaNacimiento;
	private Mamifero padre;
	private Mamifero madre;
	
	
	public Mamifero () {
	}
	
	public Mamifero (String identificador) {
		this.identificador = identificador;
	}
	
	
	public boolean tieneComoAncestroA (Mamifero m) {
		boolean aux = false;
		if (this.getMadre() == m || this.getPadre() == m) {
			return true;
		}
		else {
			if (this.getMadre() != null) {
				aux = this.getMadre().tieneComoAncestroA(m);
			}
			if ((aux != true) && (this.getPadre() != null))
				aux = this.getPadre().tieneComoAncestroA(m);
			}
		return aux;
	}
	
	
	public String getIdentificador() {
		return identificador;
	}


	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}


	public String getEspecie() {
		return especie;
	}


	public void setEspecie(String especie) {
		this.especie = especie;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public Mamifero getPadre() {
		return padre;
	}


	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}


	public Mamifero getMadre() {
		return madre;
	}


	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}


	public Mamifero getAbuelaMaterna() {
		return (this.madre != null) ? this.madre.getMadre() : null;
	}


	public Mamifero getAbueloMaterno() {
		return (this.madre != null) ? this.madre.getPadre() : null;
	}

	

	public Mamifero getAbuelaPaterna() {
		return (this.padre != null) ? this.padre.getMadre() : null;
	}



	public Mamifero getAbueloPaterno() {
		return (this.padre != null) ? this.padre.getPadre() : null;
	}

	
}
