/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoej04;


public class Director extends Integrante {
    private int antiguedad;
    
    public Director (String unNombre, int unDNI, int unaEdad, int unaAntiguedad){
        super(unNombre,unDNI,unaEdad);
        this.antiguedad = unaAntiguedad;
    }
    
    public String toString(){
        String aux = super.toString() + " ,antiguedad: " + this.antiguedad;
        return aux;
    }
    
}
