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
public class AlumnoDeGrado extends Alumno {
    private String carrera;
    
    public AlumnoDeGrado (int unDni, String unNombre, int unN, String unaCarrera) {
        super(unDni,unNombre,unN);
        this.carrera=unaCarrera;
    }
    
    public String toString () {
     String aux = super.toString() + "carrera: " + this.carrera;
     return aux;
        
}
    
    
    
    
}
