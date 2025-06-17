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
public class Materia {
    private String nombre;
    private int nota;
    private String fecha;
    
    public Materia (String unNombre, int unaNota, String unaFecha){
        this.nombre=unNombre;
        this.nota=unaNota;
        this.fecha=unaFecha;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String toString(){
        String aux;
        aux= " Materia: " + this.nombre + ", nota: " + this.nota + ", fecha " + this.fecha;
        return aux;
    }
    
    
    
}
