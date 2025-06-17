package ar.edu.info.unlp.balanzaElectronica;

public class Balanza {
	private int cantidadProductos=0;
	private double precioTotal=0;
	private double pesoTotal=0;
	
	public void ponerEnCero() {
		this.cantidadProductos=0;
		this.precioTotal=0;
		this.pesoTotal=0;
	}
	
	
	public void agregarProducto(Producto P) {
		this.cantidadProductos++;
		this.precioTotal += P.getPrecio();
		this.pesoTotal += P.getPeso();
	}
	
	public Ticket emitirTicket () {
		Ticket T = new Ticket (cantidadProductos,precioTotal,pesoTotal);
		return T;
	}


	public int getCantidadDeProductos() {
		return cantidadProductos;
	}


	public double getPrecioTotal() {
		return precioTotal;
	}


	


	public double getPesoTotal() {
		return pesoTotal;
	}


	
	
	
	
}
