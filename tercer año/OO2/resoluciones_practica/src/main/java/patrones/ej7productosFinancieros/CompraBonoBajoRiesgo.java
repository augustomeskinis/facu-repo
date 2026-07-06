package patrones.ej7productosFinancieros;

public class CompraBonoBajoRiesgo extends ProductoFinanciero{
    private int parking;

    public CompraBonoBajoRiesgo(int parking){
        this.parking=parking;
    }


    public double retornoInversion(double montoInicial){
        int numeroAleatorio = (int) (Math.random() * 1.10);
        return (montoInicial*numeroAleatorio) + this.parking;
    }
}
