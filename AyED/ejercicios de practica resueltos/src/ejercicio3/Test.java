package ejercicio3;

public class Test {
    public static void main (String [] args){
        Estudiante estudiantes [] = new Estudiante[2];
        Profesor profesores [] = new Profesor[3];


        estudiantes[0] = new Estudiante("pepe","gomez"
        , 1, "pepe@yahoo.com", "calle 2 n4");
        estudiantes[1] = new Estudiante("juan","gomez"
                , 2, "juan@yahoo.com", "calle 5 n3");
        profesores[0] = new Profesor("walter","herman",
                "walterherman@yahoo.com", 3, "informatica");
        profesores[1] = new Profesor("gonza","villarueal",
                "gonzavillaruel@yahoo.com", 2, "informatica");
        profesores[2] = new Profesor("marta","lopez",
                "martalopez@yahoo.com", 9, "informatica");

        for (int i=0;i<2;i++){
            System.out.println(estudiantes[i].tusDatos());
        }
        for (int i=0;i<3;i++){
            System.out.println(profesores[i].tusDatos());
        }
    }




}
