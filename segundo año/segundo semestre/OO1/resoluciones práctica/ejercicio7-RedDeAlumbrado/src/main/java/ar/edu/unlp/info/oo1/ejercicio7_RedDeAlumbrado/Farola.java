package ar.edu.unlp.info.oo1.ejercicio7_RedDeAlumbrado;

import java.util.ArrayList;
import java.util.List;

public class Farola {
	private boolean encendida;
	private List <Farola> Neighbors;
	
	public Farola () {
		this.encendida = false;
		this.Neighbors = new ArrayList<> (); 
	}
	
	public void addNeighbor (Farola otraFarola) {
		this.Neighbors.add(otraFarola);
	}
	
	public void pairWithNeighbor (Farola otraFarola) {
		this.Neighbors.add(otraFarola);
		otraFarola.addNeighbor(this);
	}
	
	
	public List <Farola> getNeighbors (){
		return (this.Neighbors);
	}
	
	public boolean isOn () {
		return (this.encendida);
	}
	
	public boolean isOff() {
		return (!this.encendida);
	}
	
	public void turnOn () {
		if (!(this.encendida)) {
			this.encendida = true;
			for (Farola F: Neighbors) {
				F.turnOn();
			}
		}
	}
	
	public void turnOff() {
		if (this.encendida) {
			this.encendida = false;
			for(Farola F: Neighbors) {
				F.turnOff();
			}
		}
	}
	
}
