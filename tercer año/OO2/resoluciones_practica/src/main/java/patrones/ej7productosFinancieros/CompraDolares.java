package patrones.ej7productosFinancieros;

public class CompraDolares extends ProductoFinanciero{
    private double valorCompra;

    public double retornoInversion(double montoInicial){
        this.valorCompra=montoInicial/1500;
        return valorCompra;
    }
}
