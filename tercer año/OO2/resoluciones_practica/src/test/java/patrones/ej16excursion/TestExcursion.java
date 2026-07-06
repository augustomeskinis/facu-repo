package patrones.ej16excursion;

import java.time.LocalDate;

public class TestExcursion {

    public static void main (String [] args){
        Excursion excursion = new Excursion("Dos días en kayak bajando el parana", LocalDate.of(2026,6,1),
                                            LocalDate.of(2026,6,3),"por ahi",500,2,1);
        System.out.println(excursion.obtenerInformacion());
        Usuario usuario1 = new Usuario("pepe","matrinez","pepe@gmail.com");
        excursion.inscribir(usuario1);
        System.out.println(excursion.obtenerInformacion());
        Usuario usuario2 = new Usuario("juan", "gonzalez", "juan@gmail.com");
        excursion.inscribir(usuario2);
        System.out.println(excursion.obtenerInformacion());
        Usuario usuario3 = new Usuario("pipi", "gonzalez", "pipi@gmail.com");
        excursion.inscribir(usuario3);
        System.out.println(excursion.obtenerInformacion());
    }

}
