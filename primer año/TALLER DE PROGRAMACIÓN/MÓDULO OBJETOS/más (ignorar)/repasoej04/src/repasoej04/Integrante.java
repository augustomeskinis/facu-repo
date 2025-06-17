/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoej04;

public abstract class Integrante {
    private String nombre;
    private int DNI;
    private int edad;

    public Integrante (String unNombre, int unDNI, int unaEdad){
        this.nombre=unNombre;
        this.DNI=unDNI;
        this.edad=unaEdad;
    }
    
    public String toString (){
        String aux = "nombre: " + this.nombre + " ,DNI: " + this.DNI + " ,edad: " + this.edad;
        return aux;
    }

    
}
