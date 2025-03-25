package practica1.ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class IncisosDEF {
    public static void crearListasEstudiantes() {
        List<Estudiante> lista1 = new ArrayList<>();
        Estudiante Juan = new Estudiante("juan", "perez", 1, "juan@yahoo.com", "calle4");
        Estudiante pedro = new Estudiante("pedro", "perez", 2, "pedro@yahoo.com", "calle4");
        Estudiante elisa = new Estudiante("elisa", "perez", 1, "elisa@yahoo.com", "calle4");
        lista1.add(Juan);lista1.add(pedro);lista1.add(elisa);
        List<Estudiante> lista2 = new ArrayList<>();
        lista2 = lista1;
        for (int i=0; i<3;i++) {
            System.out.println(lista1.get(i).tusDatos());
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(lista2.get(i).tusDatos());
        }
        elisa.setApellido("ramos");
        for (int i = 0; i < 3; i++) {
            System.out.println(lista1.get(i).tusDatos());
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(lista2.get(i).tusDatos());
        }
    }
    public static void main (String [] args){
        crearListasEstudiantes();
    }
}
