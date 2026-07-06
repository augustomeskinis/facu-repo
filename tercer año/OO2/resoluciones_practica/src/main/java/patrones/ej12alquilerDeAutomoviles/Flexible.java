package patrones.ej12alquilerDeAutomoviles;

import java.time.LocalDate;

public class Flexible extends PoliticaDeCancelacion {

    @Override
    public double montoAReembolsar (double monto, LocalDate fecha){
        LocalDate fechaActual = LocalDate.now();
        if (fecha.isBefore(fechaActual)){
            return monto;
        }
        System.out.println("ya empezó la reserva");
        return monto;
    }

}
