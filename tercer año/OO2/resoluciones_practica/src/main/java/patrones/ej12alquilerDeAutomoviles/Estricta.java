package patrones.ej12alquilerDeAutomoviles;

import java.time.LocalDate;

public class Estricta extends PoliticaDeCancelacion {

    @Override
    public double montoAReembolsar(double monto, LocalDate fecha) {
        return 0;
    }
}
