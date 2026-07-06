package patrones.ej7productosFinancieros;

public class CompraBonoAltoRiesgo extends ProductoFinanciero {
    private int parking;

    public CompraBonoAltoRiesgo (int parking){
        this.parking=parking;
    }

    public double retornoInversion(double montoInicial){
        int numeroAleatorio = (int) (Math.random() * 1.70);
        return (montoInicial*numeroAleatorio) + this.parking;
    }
}
