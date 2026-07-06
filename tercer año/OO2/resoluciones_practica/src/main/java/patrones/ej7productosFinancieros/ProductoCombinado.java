package patrones.ej7productosFinancieros;

import java.util.ArrayList;
import java.util.List;

public class ProductoCombinado extends ProductoFinanciero {
    private List<ProductoFinanciero> productos;

    public ProductoCombinado(){
        this.productos=new ArrayList<>();
    }

    public void add(ProductoFinanciero productoFinanciero){
        this.productos.add(productoFinanciero);
    }

    // Implementar retornoInversion() sumando todos los productos
    @Override
    public double retornoInversion(double montoInicial) {
        return productos.stream()
                .mapToDouble(p -> p.retornoInversion(montoInicial))
                .sum();
    }
}
