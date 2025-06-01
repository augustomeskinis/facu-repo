/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;
import PaqueteLectura.Lector;
/**
 *
 * @author Augusto
 */
public class Ej01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Ingrese el lado 1");
        double lado1 = Lector.leerDouble();
        System.out.println("Ingrese el lado 2");
        double lado2 = Lector.leerDouble();
        System.out.println("Ingrese el lado 3");
        double lado3 = Lector.leerDouble();
        System.out.println("Ingrese un color de relleno");
        String relleno = Lector.leerString();
        System.out.println("Ingrese un color de linea");
        String linea = Lector.leerString();
        Triangulo T = new Triangulo (lado1,lado2,lado3,relleno,linea);
        System.out.println("El perimetro es: " + T.calcularPerimetro());
        System.out.println("El área es: " + T.calcularArea());

        
        
    }
    
}
