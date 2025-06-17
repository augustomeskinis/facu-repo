/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoej04;

public class Corista extends Integrante {
    private int tonoFundamental;
    
    public Corista (String unNombre, int unDNI, int unaEdad, int unTonoFundamental){
        super(unNombre,unDNI,unaEdad);
        this.tonoFundamental=unTonoFundamental;
    }
    
    public String toString(){
        String aux = super.toString() + " ,tono fundamental: " + this.tonoFundamental;
        return aux;
    }

    public int getTonoFundamental() {
        return tonoFundamental;
    }
    
    
    
    
    
    
    
    
    
    
}
