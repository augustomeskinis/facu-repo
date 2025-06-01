package ar.edu.unlp.info.oo1.ejercicio19_ServicioDeEnviosDePaquetes;

public class ClienteCorporativo extends Cliente {
	private int CUIT;

	public ClienteCorporativo(String nombre, String direccion, int cUIT) {
		super(nombre, direccion);
		CUIT = cUIT;
	}
	
	
	
}
