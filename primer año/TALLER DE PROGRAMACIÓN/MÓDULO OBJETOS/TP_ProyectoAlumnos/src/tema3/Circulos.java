/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author Alumno
 */
public class Circulos {
    private double radio;
    private String colorRelleno;
    private String colorLinea;

    public Circulos(double radio, String colorRelleno, String colorLinea) {
        this.radio = radio;
        this.colorRelleno = colorRelleno;
        this.colorLinea = colorLinea;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public String getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public String getColorLinea() {
        return colorLinea;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
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
 
    
    
    
}
