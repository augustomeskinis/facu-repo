package patrones.ej7productosFinancieros;

public class ProductoCombinadoBuilder {
    private ProductoCombinado productoCombinado;

    public ProductoCombinadoBuilder(){
        this.productoCombinado=new ProductoCombinado();
    }

    public ProductoCombinado buildProducto1(int cantidadDias, double interes){
        CompraDolares compraDolares = new CompraDolares();
        PlazoFijo plazoFijo = new PlazoFijo(cantidadDias, interes);
        CompraPesos compraPesos = new CompraPesos();
        this.productoCombinado.add(compraDolares);
        this.productoCombinado.add(plazoFijo);
        this.productoCombinado.add(compraPesos);
        return productoCombinado;
    }

    public ProductoCombinado buildProducto2(int cantidadDias, double interes, int parking){
        CompraBonoBajoRiesgo compraBonoBajoRiesgo = new CompraBonoBajoRiesgo(parking);
        CompraDolares compraDolares = new CompraDolares();
        PlazoFijo plazoFijo = new PlazoFijo(cantidadDias,interes);
        CompraPesos compraPesos = new CompraPesos();
        this.productoCombinado.add(compraBonoBajoRiesgo);
        this.productoCombinado.add(compraDolares);
        this.productoCombinado.add(plazoFijo);
        return productoCombinado;
    }

    public ProductoCombinado buildProducto3(int cantidadDias, double interes, int parking){
        CompraBonoAltoRiesgo compraBonoAltoRiesgo = new CompraBonoAltoRiesgo(parking);
        CompraBonoBajoRiesgo compraBonoBajoRiesgo = new CompraBonoBajoRiesgo(parking);
        PlazoFijo plazoFijo = new PlazoFijo(cantidadDias,interes);
        this.productoCombinado.add(compraBonoAltoRiesgo);
        this.productoCombinado.add(compraBonoBajoRiesgo);
        this.productoCombinado.add(plazoFijo);
        return productoCombinado;
    }


    public ProductoCombinado buildProducto4(int parking){
        CompraBonoAltoRiesgo compraBonoAltoRiesgo = new CompraBonoAltoRiesgo(parking);
        CompraBonoBajoRiesgo compraBonoBajoRiesgo = new CompraBonoBajoRiesgo(parking);
        CompraBonoAltoRiesgo compraBonoAltoRiesgo2 = new CompraBonoAltoRiesgo(parking);
        this.productoCombinado.add((compraBonoAltoRiesgo2));
        this.productoCombinado.add(compraBonoBajoRiesgo);
        this.productoCombinado.add(compraBonoAltoRiesgo);
        return productoCombinado;
    }



}
