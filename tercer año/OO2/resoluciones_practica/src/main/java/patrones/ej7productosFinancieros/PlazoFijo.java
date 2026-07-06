package patrones.ej7productosFinancieros;

public class PlazoFijo extends ProductoFinanciero{
    private int cantidadDias;
    private double interes;

    public PlazoFijo (int cantidadDias, double interes){
        this.cantidadDias=cantidadDias;
        this.interes=interes;
    }

    public double retornoInversion(double montoInicial){
        return montoInicial*this.cantidadDias*this.interes;
    }

}
