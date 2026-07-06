package patrones.ej12alquilerDeAutomoviles;

import java.time.LocalDate;

public class SNIPPET {

    public static void main(String[] args) {
        // Crear automóvil con política flexible

        AutoEnAlquiler auto = new AutoEnAlquiler(100, 5, "Toyota", new Flexible());

        // Crear reserva de 5 días
        Reserva reserva = new Reserva(5, LocalDate.of(2026, 5, 22), auto, new Usuario("Pepe"));

        double monto = reserva.montoAPagar();  // 100 * 5 = 500

        // Imprimir reembolso con política flexible
        System.out.println("Reembolso Flexible: $" + reserva.montoAReembolsar());
        // Output: Reembolso Flexible: $500.0

        // Cambiar a política moderada
        auto.setPolitica(new Moderada());
        System.out.println("Reembolso Moderada: $" + reserva.montoAReembolsar());
        // Output: Reembolso Moderada: $500.0 (suponiendo que cancelación es 7+ días antes)
    }
}
