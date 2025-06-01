package ar.edu.unlp.info.oo1.ejercicio13_ClienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
	private String nombre;
	private List <Email> emails;
	
		
	public Carpeta (String unNombre) {
		this.nombre = unNombre;
		this.emails = new ArrayList <Email>();
	}


	public String getNombre() {
		return nombre;
	}
	
	
	public void agregarCorreo(Email email) {
		this.emails.add(email);
	}
	
	
	public void mover (Email email, Carpeta c) {
		this.emails.remove(email);
		c.agregarCorreo(email);
	}
	
	
	public Email buscar (String texto) {
		Email E = this.emails.stream().filter(email -> email.buscar(texto)).findFirst().orElse(null);
		return E;
	}
	
	public int espacioOcupado() {
		int aux = 0;
		aux = this.emails.stream().mapToInt(email -> email.espacioOcupado()).sum();
		return aux;
	}
	
	
}
