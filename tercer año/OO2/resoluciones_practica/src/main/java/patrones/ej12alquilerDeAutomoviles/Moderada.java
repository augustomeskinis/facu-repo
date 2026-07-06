package patrones.ej12alquilerDeAutomoviles;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Moderada extends PoliticaDeCancelacion {

    @Override
    public double montoAReembolsar(double monto, LocalDate fecha) {
        LocalDate fechaActual = LocalDate.now();
        long dias = ChronoUnit.DAYS.between(fechaActual,fecha);
        if (dias >= 7){
            return monto;
        }
        if (dias >= 2) {
            return monto * 0.50;
        }
        return 0;
    }
}
