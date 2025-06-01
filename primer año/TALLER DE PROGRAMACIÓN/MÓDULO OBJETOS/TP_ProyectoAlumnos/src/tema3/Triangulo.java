/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author Augusto
 */
public class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;
    private String colorRelleno;
    private String colorLinea;
    
    public Triangulo (double unLado1, double unLado2, double unLado3, String unColorRelleno, String unColorLinea){
        setLado1(unLado1);
        setLado2(unLado2);
        setLado3(unLado3);
        setColorRelleno(unColorRelleno);
        setColorLinea(unColorLinea);
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
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
    
    public double calcularPerimetro(){
        return(lado1 + lado2 + lado3);
    }
    
    public double calcularArea(){
        double s = ( (lado1 + lado2 + lado3) / 3 );
        double area = (s*(s-lado1)*(s-lado2)*(s-lado3));
        return(Math.sqrt(area));
    }

    
    
}
