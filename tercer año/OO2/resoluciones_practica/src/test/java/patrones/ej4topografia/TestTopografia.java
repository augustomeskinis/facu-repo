package patrones.ej4topografia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTopografia {
    ComponenteAgua agua = new ComponenteAgua();
    ComponenteTierra tierra = new ComponenteTierra();
    List<Componente>componentes=new ArrayList<>();
    Topografia topografia;

    @BeforeEach
    public void setUp(){
        componentes.add(agua);
        componentes.add(tierra);
        componentes.add(agua);
        componentes.add(tierra);
        topografia = new Topografia(componentes);
    }

    @Test
    public void testGetProporcion(){
        assertEquals(0.5, topografia.getProporcion());
    }


}
