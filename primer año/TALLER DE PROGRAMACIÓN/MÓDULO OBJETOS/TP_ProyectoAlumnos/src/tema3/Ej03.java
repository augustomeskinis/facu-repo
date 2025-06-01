
package tema3;
import PaqueteLectura.GeneradorAleatorio;
public class Ej03 {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        Libro A = new Libro ();
        Libro B = new Libro ();
        Libro C = new Libro ();
        Libro D = new Libro ();
        
        Autor Z = new Autor ("Herbert Schildt", "tuvo una esposa, tres hijos y publico 24 libros", "Quilmes")  ;
        Libro X = new Libro ("Mujercitas", "jajajajajaj",2018, Z, "IERUWIOREWIR", 342.34);
                
        Estante E = new Estante ();
        
        E.agregarLibro(A);
        E.agregarLibro(B);
        E.agregarLibro(C);
        E.agregarLibro(D);
        E.agregarLibro(X);
        
        System.out.println(E.estaLleno());
        System.out.println(E.devolverLibro("Mujercitas").getPrimerAutor());
    }
    
}
