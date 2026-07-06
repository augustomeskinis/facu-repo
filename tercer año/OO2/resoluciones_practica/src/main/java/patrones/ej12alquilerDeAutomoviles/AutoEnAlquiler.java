package patrones.ej12alquilerDeAutomoviles;

import java.time.LocalDate;

public class AutoEnAlquiler {
    private double precioPorDia;
    private int cantidadPlazas;
    private String marca;
    private PoliticaDeCancelacion politicaDeCancelacion;

    public AutoEnAlquiler(double precioPorDia, int cantidadPlazas, String marca, PoliticaDeCancelacion politicaDeCancelacion){
        this.precioPorDia=precioPorDia;
        this.cantidadPlazas=cantidadPlazas;
        this.marca=marca;
        this.politicaDeCancelacion=politicaDeCancelacion;
    }

    public double getPrecioPorDia(){
        return this.precioPorDia;
    }

    public double montoAReembolsar (double monto, LocalDate fecha){
        return this.politicaDeCancelacion.montoAReembolsar(monto,fecha);
    }

    public void setPolitica(PoliticaDeCancelacion politica){
        this.politicaDeCancelacion=politica;
    }
}
