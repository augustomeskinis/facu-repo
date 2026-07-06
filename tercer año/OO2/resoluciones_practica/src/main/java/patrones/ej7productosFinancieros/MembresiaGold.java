package patrones.ej7productosFinancieros;

public class MembresiaGold extends Membresia {

    public MembresiaGold(){
        super();
        this.productoCombinado2=productoCombinadoBuilder.buildProducto2(30,0.6,24);
    }

}
