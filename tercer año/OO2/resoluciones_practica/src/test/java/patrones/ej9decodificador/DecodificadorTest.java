package patrones.ej9decodificador;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecodificadorTest {

    private Decodificador decodificador;
    private Similaridad similaridad;
    private Puntaje puntaje;
    private Pelicula Thor;
    private Pelicula CapitanAmerica;
    private Pelicula IronMan;
    private Pelicula Dunkink;
    private Pelicula Rocky;
    private Pelicula Rambo;

    @BeforeEach
    public void setUp(){
        this.decodificador=new Decodificador();
        this.similaridad=new Similaridad(decodificador);
        this.puntaje=new Puntaje(decodificador);

        Thor = new Pelicula("Thor", 7.9, 2007);
        decodificador.addPelicula(Thor);
        CapitanAmerica = new Pelicula("Capitan America",7.8,2016);
        decodificador.addPelicula(CapitanAmerica);
        IronMan = new Pelicula("Iron Man", 7.9, 2010);
        decodificador.addPelicula(IronMan);
        Dunkink = new Pelicula("Dunkirk",7.9,2017);
        decodificador.addPelicula(Dunkink);
        Rocky = new Pelicula("Rocky",8.1,1976);
        decodificador.addPelicula(Rocky);
        Rambo = new Pelicula("Rambo", 7.8,1979);

        Thor.addPeliculaSimilar(CapitanAmerica);
        Thor.addPeliculaSimilar(IronMan);

        CapitanAmerica.addPeliculaSimilar(Thor);
        CapitanAmerica.addPeliculaSimilar(IronMan);

        IronMan.addPeliculaSimilar(Thor);
        IronMan.addPeliculaSimilar(CapitanAmerica);

        Rocky.addPeliculaSimilar(Rambo);

        Rambo.addPeliculaSimilar(Rocky);

        decodificador.addPeliculaVista(Thor);
        decodificador.addPeliculaVista(Rocky);
    }
    @Test
    public void testSimilaridad(){
        this.decodificador.cambiarContexto(similaridad);
        // Las películas que debería sugerir son: (ii) Capitán América,  Iron man, Rambo
        assertEquals(3, decodificador.sugerencias().size());
        assertTrue(decodificador.sugerencias().contains(Rambo));
        assertTrue(decodificador.sugerencias().contains(CapitanAmerica));
        assertTrue(decodificador.sugerencias().contains(IronMan));
    }

    @Test
    public void testPuntaje(){
        this.decodificador.cambiarContexto(puntaje);
        assertEquals(3, decodificador.sugerencias().size());
        // Las películas que debería sugerir son : (iii) Dunkirk, Iron man, Capitan America
        assertTrue(decodificador.sugerencias().contains(Dunkink));
        assertTrue(decodificador.sugerencias().contains(IronMan));
        assertTrue(decodificador.sugerencias().contains(CapitanAmerica));
        assertFalse(decodificador.sugerencias().contains(Rambo));
    }


}
