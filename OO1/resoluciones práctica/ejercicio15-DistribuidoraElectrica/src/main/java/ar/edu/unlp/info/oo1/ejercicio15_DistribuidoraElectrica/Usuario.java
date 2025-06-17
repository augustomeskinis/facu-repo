package ar.edu.unlp.info.oo1.ejercicio15_DistribuidoraElectrica;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private String domicilio;
	private List <Consumo> consumos;
	
	public Usuario(String unNombre, String unDomicilio) {
		consumos = new ArrayList<Consumo>();
		this.setDomicilio(unDomicilio);
		this.setNombre(unNombre);
		
	}

	public void agregarConsumo (Consumo consumo) {
		this.consumos.add(consumo);
	}
	
	public Factura emitirFactura(CuadroTarifario tarifa) {
		Consumo ultimo = this.getUltimoConsumo();
		double montoFinal = ultimo.costo(tarifa.getPrecioKWH());
		boolean bonificacion = this.calcularHayBonificacion(ultimo);
		if(bonificacion) {
			montoFinal *= 0.9;
		}
		return(new Factura(this,bonificacion,montoFinal));
	}
	
	private boolean calcularHayBonificacion(Consumo consumo) {
		return consumo.factorDePotencia() > 0.8;						  
	}
	
	public Consumo getUltimoConsumo() {
		return (this.consumos.get(this.consumos.size()-1));
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	
	
	
}
