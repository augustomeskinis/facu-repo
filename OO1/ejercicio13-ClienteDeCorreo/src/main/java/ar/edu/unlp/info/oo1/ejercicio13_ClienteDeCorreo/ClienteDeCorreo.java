package ar.edu.unlp.info.oo1.ejercicio13_ClienteDeCorreo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDeCorreo {
	private List <Carpeta> carpetas;
	private Carpeta inbox;
	
	
	public ClienteDeCorreo () {
		this.carpetas = new ArrayList <Carpeta>();
		this.inbox = new Carpeta("inbox");
	}
	
	public void recibir(Email email) {
		this.inbox.agregarCorreo(email);
	}
	
	
	public Email buscar(String texto) {
		Email E = this.inbox.buscar(texto);
		if (E == null) {
			E = carpetas.stream()
				.map(carpeta -> carpeta.buscar(texto))
				.filter(e -> e != null)
				.findFirst()
				.orElse(null);
		}
		return E;
	}
	
	public int espacioOcupado() {
		int aux = this.inbox.espacioOcupado();
		aux += carpetas.stream().mapToInt(carpeta -> carpeta.espacioOcupado()).sum();
		return aux;
	}
	
	
}
