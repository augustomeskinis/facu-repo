package patrones.ej12alquilerDeAutomoviles;

import java.time.LocalDate;

public abstract class PoliticaDeCancelacion {

    public abstract double montoAReembolsar(double monto, LocalDate fecha);

}
