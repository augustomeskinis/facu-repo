package patrones.ej7productosFinancieros;

public abstract class Membresia {
    protected ProductoCombinadoBuilder productoCombinadoBuilder;
    protected ProductoCombinado productoCombinado1;
    protected ProductoCombinado productoCombinado2;

    public Membresia(){
        productoCombinadoBuilder = new ProductoCombinadoBuilder();
        this.productoCombinado1=productoCombinadoBuilder.buildProducto1(35,0.5);
    }
}
