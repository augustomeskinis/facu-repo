/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;
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
        System.out.println("Ingrese un nombre, un dni y una edad");
        Persona P = new Persona (Lector.leerString(), Lector.leerInt(), Lector.leerInt());
        System.out.println(P.toString());

    }
    
}
