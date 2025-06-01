/*
Demo que crea objetos Libro invocando a los constructores definidos. 
 */
package tema3;

/**
 *
 * @author vsanz
 */
public class Demo01ConstructoresLibro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Autor A = new Autor ("Herbert Schildt", "tuvo una esposa, tres hijos y publico 24 libros", "Quilmes")  ;   
        
        Libro libro1= new  Libro( "Java: A Beginner's Guide",   
                                 "Mcgraw-Hill", 2014,   
                                 A, "978-0071809252", 21.72);
        
        Autor B = new Autor ("John Horton", "tuvo una esposa, cuatro hijos y publico 24 libro," ,"La plata");
        
        Libro libro2= new Libro("Learning Java by Building Android Games",  
                              "CreateSpace Independent Publishing", 
                               B, "978-1512108347");
        
        System.out.println("Libro 1 " + libro1.toString());
        System.out.println("Libro 2 "  + libro2.toString());
        System.out.println();
        System.out.println("Precio del libro2: " +libro2.getPrecio());
        System.out.println("Año edición del libro2: " +libro2.getAñoEdicion());
        Libro libro3= new Libro(); 
    }
    
}
