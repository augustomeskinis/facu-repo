package patrones.ej2sueldos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpleadoTest {

    // testeo el empleado Temporario
    @Test
    public void testTemporario(){
        EmpleadoTemporario empleadoT = new EmpleadoTemporario(2,2,true);

        // testeo el sueldo basico
        int basico = 20000 + (2*300); // $ 20.000 + cantidad de horas que  trabajó * $ 300.
        assertEquals(basico,empleadoT.basico());

        //testeo el adicional
        int adicional = 5000 + (2000*2);// $5.000 si está casado, $2.000 por cada hijo
        assertEquals(adicional,empleadoT.adicional());

        // testeo el descuento
        double descuento = (basico*0.13) + (adicional*0.05); // 13% del sueldo básico, 5% del sueldo adicional
        assertEquals(descuento,empleadoT.descuento());

        //testeo el sueldo
        double sueldo = basico + adicional - descuento;
        assertEquals(sueldo,empleadoT.sueldo());

    }

    // testeo el empleado pasante
    @Test
    public void testPasante(){
        EmpleadoPasante empleadoP = new EmpleadoPasante(0,false);
        // testeo solo el sueldo, lo otro no hace falta
        double descuento = (20000*0.13) + (2000*0.05);
        double sueldo = 20000 + 2000 - descuento;
        assertEquals(sueldo,empleadoP.sueldo());
    }

    @Test
    public void testPlanta(){
        EmpleadoPlanta empleadoP = new EmpleadoPlanta(2,true,5);

        // testeo el adicional
        int adicional=5000+(2000*2)+(2000*5);
        assertEquals(adicional,empleadoP.adicional());

        // testeo el descuento
        double descuento=(50000*0.13)+(adicional*0.05);
        assertEquals(descuento,empleadoP.descuento());

        // testeo el sueldo
        double sueldo = 50000 + adicional - descuento;
        assertEquals(sueldo,empleadoP.sueldo());

    }

}
