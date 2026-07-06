package refactoring.ejercicio3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RingTest {
    // CharRingTest
    @Test
    void retornaElSiguienteCaracter() {
        CharRing ring = new CharRing("abc");
        assertEquals('a', ring.next());
        assertEquals('b', ring.next());
        assertEquals('c', ring.next());
    }

    @Test
    void vuelveAlInicioAlLlegarAlFinal() {
        CharRing ring = new CharRing("ab");
        ring.next(); ring.next();
        assertEquals('a', ring.next()); // vuelve al inicio
    }

    // IntRingTest
    @Test
    void retornaElSiguienteEntero() {
        IntRing ring = new IntRing(new int[]{1, 2, 3});
        assertEquals(1, ring.next());
        assertEquals(2, ring.next());
        assertEquals(3, ring.next());
    }

    @Test
    void vuelveAlInicioAlLlegarAlFinal2() {
        IntRing ring = new IntRing(new int[]{10, 20});
        ring.next(); ring.next();
        assertEquals(10, ring.next());
    }
}
