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
import PaqueteLectura.Lector;

public class Ej05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circulos C;
        double r; String rell; String linea;
        System.out.print("Introducir radio del circulo: ");
        r = Lector.leerDouble();
        System.out.print("Introducir color de relleno del circulo: ");
        rell = Lector.leerString();
        System.out.print("Introducir color de linea del circulo: ");
        linea = Lector.leerString();
        C = new Circulos(r, rell, linea);
        System.out.println("El circulo tiene un perimetro de " + C.calcularPerimetro());
        System.out.println("El circulo tiene un area de " + C.calcularArea());
    }
    
}
