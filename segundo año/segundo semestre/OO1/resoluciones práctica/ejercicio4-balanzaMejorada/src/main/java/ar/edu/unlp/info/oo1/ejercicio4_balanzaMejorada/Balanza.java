package ar.edu.unlp.info.oo1.ejercicio4_balanzaMejorada;

import java.util.ArrayList;
import java.util.List;

public class Balanza {
	private List<Producto> productos;
	
	public Balanza () {
		productos = new ArrayList<Producto> ();
	}
	
	public List<Producto> getProductos(){
		return this.productos;
	}
	public void ponerEnCero() { 
			this.productos=new ArrayList<Producto> ();
	}
	
	public void agregarProducto(Producto P) {
		productos.add(P);
	}
	
	public Ticket emitirTicket () {
		Ticket T = new Ticket (this.productos);
		return T;
	}
	

	public int getCantidadDeProductos() {
		return this.productos.size();
	}


	public double getPrecioTotal() {
		double aux=0;
		for(Producto P: productos) {
			aux += P.getPrecio();
		}
		return aux;
	}
	

	public double getPesoTotal() {
		double aux=0;
		for (Producto P: productos) {
			aux+= P.getPeso();
		}
		return aux;
	}

	
}
