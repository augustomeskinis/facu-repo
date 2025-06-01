
package tema3;

/**
 *
 * @author Augusto
 */
public class Estante {
    private int df = 20;
    private Libro vector [] = new Libro [df];
    private int dl = 0;

    public Estante() {
    }
    
    public int getCantidadLibros (){
        return dl;
    }
    
    public String estaLleno(){
        String aux;
        if (dl == 19){
            aux = "El estante está lleno";
        }
        else {
            aux = "El estante no está lleno";
        }
        return aux;
    }
    
    public void agregarLibro(Libro L){
        vector[dl] = new Libro (L.getTitulo(),L.getEditorial(),
                L.getAñoEdicion(),L.getPrimerAutor(), L.getISBN(), L.getPrecio());
        dl++;
    }
    
    public Libro devolverLibro (String titulo){
        int i=0; Libro L = new Libro();
        while ( (i<dl) &&  !(vector[i].getTitulo().equals(titulo))){
            i++;
        }
        if (vector[i].getTitulo().equals(titulo)) {
            L = vector[i];
        }
        return L;
    }
    
}
