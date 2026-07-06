package patrones.ej5elementosQuimicos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElementosQuimicosTest {

    @Test
    public void testAgua() {
        ElementoQuimico h1 = new Hidrogeno();
        ElementoQuimico h2 = new Hidrogeno();
        ElementoQuimico o = new Oxigeno();

        Union agua = new Union();
        agua.addElemento(h1);
        agua.addElemento(h2);
        agua.addElemento(o);

        assertEquals("HHO", agua.formula());
        assertEquals(18, agua.pesoAtomico());
        assertEquals(0, agua.cargaElectrica());
        assertTrue(agua.esValida());
    }
}