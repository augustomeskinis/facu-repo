/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasando;

import PaqueteLectura.Lector;

/**
 *
 * @author Augusto
 */
public class Ej02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Auto a = new Auto("pepe",1234);
        Auto a2 = new Auto("juan",2425);
        Auto a3 = new Auto("augusto",7543);
        Auto a4 = new Auto("joaco",9879);
        Auto a5 = new Auto("mati",4321);
        Auto a6 = new Auto("pancho",5433);
        
        Estacionamiento E = new Estacionamiento("Park", "7 y 50", 7.00, 21.00, 3,3);
        
        E.agregarAuto(a, 1, 1);
        E.agregarAuto(a2, 3, 2);
        E.agregarAuto(a3, 2, 2);
        E.agregarAuto(a4, 3, 3);
        E.agregarAuto(a5, 1, 2);
        E.agregarAuto(a6, 2, 1);
        
        System.out.println(E.toString());
        System.out.println("Cantidad de autos en la plaza 1:   " + E.getCantidad(1));
        System.out.println("\n"+"ingrese una patente: "+"\n");
        int patente = Lector.leerInt();
        System.out.println(E.dondeEsta(patente));
    }
    
}
