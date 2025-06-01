/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Augusto
 */
public class Ej01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Triangulo T = new Triangulo (10,5,7,"azul","rojo");
        Circulos C = new Circulos (15,"verde","rosa");
        
        System.out.println(T.toString());
        System.out.println(C.toString());
        
        T.despintar();
        C.despintar();
        System.out.println(T.toString());
        System.out.println(C.toString());       
        
    }
    
}
