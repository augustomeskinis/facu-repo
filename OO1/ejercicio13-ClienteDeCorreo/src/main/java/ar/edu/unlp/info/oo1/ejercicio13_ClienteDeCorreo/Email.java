package ar.edu.unlp.info.oo1.ejercicio13_ClienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class Email {
	private String titulo;
	private String cuerpo;
	private List <Archivo> adjuntos;
	
	public Email(String unTitulo, String unCuerpo) {
		this.titulo = unTitulo;
		this.cuerpo = unCuerpo;
		this.adjuntos = new ArrayList <Archivo> ();
	}

	public void añadirArchivo(Archivo A) {
		this.adjuntos.add(A);
	}
	

	public boolean buscar(String texto) {
		return (this.cuerpo.equals(texto)|this.titulo.equals(texto));
	}
	
	
	public int espacioOcupado() {
		int aux = this.titulo.length() + this.cuerpo.length();
		aux += this.adjuntos.stream().mapToInt(archivo -> archivo.tamaño()).sum();
		return aux;
	}
	
}
