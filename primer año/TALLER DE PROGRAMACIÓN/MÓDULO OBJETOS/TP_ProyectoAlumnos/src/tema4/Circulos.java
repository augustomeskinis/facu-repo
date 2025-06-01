/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

import tema3.*;

/**
 *
 * @author Alumno
 */
public class Circulos extends Figura {
    private double radio;


    public Circulos(double radio, String colorRelleno, String colorLinea) {
        super(colorRelleno,colorLinea);
        this.radio = radio;

    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double calcularPerimetro (){
        double aux;
        aux = (2*Math.PI);
        aux = ( aux * this.getRadio() );
        return aux;
    }
    
    public double calcularArea(){
        double aux;
        aux = Math.pow(this.radio, 2);
        aux = aux * Math.PI;
        return aux;
    }
 
    public String toString(){
        String aux = super.toString() + " radio: " + this.getRadio();
        return aux;
    }
    
    
}
