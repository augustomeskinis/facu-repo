package refactoring.ejercicio5;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import refactoring.ejercicio4.CarRental;
import refactoring.ejercicio4.Company;
import refactoring.ejercicio4.TimePeriod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarRentalTest {
    private CarRental alquilerAuto;
    private LocalDate fehaFin;
    private LocalDate fechaInicio;

    @BeforeEach
    void setUp() throws Exception {
        Company compania = new Company(200, 1.3);
        this.fehaFin = LocalDate.of(2026, 1, 2);
        this.fechaInicio = LocalDate.of(2026, 1, 15);
        TimePeriod periodo = new TimePeriod(this.fechaInicio, this.fehaFin);
        this.alquilerAuto = new CarRental(300.0, periodo, compania);
    }

    @Test
    public void testStartDate() {
        assertNotNull(this.alquilerAuto.startDate(), "El alquiler del auto debe tener una fecha de inicio");
        assertEquals(this.fechaInicio, this.alquilerAuto.startDate());
    }

    @Test
    public void testEndDate() {
        assertNotNull(this.alquilerAuto.endDate(), "El alquiler del auto debe tener una fecha de finalización");
        assertEquals(this.fehaFin, this.alquilerAuto.endDate());
    }


    @Test
    public void testPrice() {
        // 200 * 1.3
        assertNotNull(this.alquilerAuto.price(), "El alquiler del auto debe tener un precio");
        assertEquals(260.0, this.alquilerAuto.price());
    }
}
