package patrones.ej12alquilerDeAutomoviles;

import java.time.LocalDate;

public class Reserva {
    private int cantidadDias;
    private LocalDate fecha;
    private AutoEnAlquiler auto;
    private Usuario usuario;

    public Reserva(int cantidadDias, LocalDate fecha, AutoEnAlquiler auto, Usuario usuario){
        this.cantidadDias=cantidadDias;
        this.fecha=fecha;
        this.auto=auto;
        this.usuario=usuario;
    }

    public double montoAPagar(){
        return this.auto.getPrecioPorDia()*this.cantidadDias;
    }

    public double montoAReembolsar(){
        return this.auto.montoAReembolsar(this.montoAPagar(),this.fecha);
    }

}
