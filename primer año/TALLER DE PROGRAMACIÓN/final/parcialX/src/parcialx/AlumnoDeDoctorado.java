/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialx;

/**
 *
 * @author Augusto
 */
public class AlumnoDeDoctorado extends Alumno {
    private String titulo;
    private String universidadOrigen;
    
    public AlumnoDeDoctorado (int unDni, String unNombre, int unN, String unTitulo, String unaUniversidad) {
        super(unDni,unNombre,unN);
        this.titulo=unTitulo;
        this.universidadOrigen=unaUniversidad;
}
    
    public String toString () {
        String aux = super.toString() + "titulo universitario: " + this.titulo 
                + " ,universidad de origen: " + this.universidadOrigen;
        return aux;
    }
    
}
