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
public class Ej04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persona cliente1 = new Persona ("Juan",123432,20);
        Persona cliente2 = new Persona ("augusto",3424214,30);
        Persona cliente3 = new Persona ("magui",4234234,34);
        
        Hotel H = new Hotel (10);
        
        H.agregarCliente(cliente3, 1);
        H.agregarCliente(cliente2, 8);
        H.agregarCliente(cliente1, 5);
        
        System.out.println(H.toString());
        
        H.aumentarHabitaciones(4560);
        
        System.out.println(H.toString());
        
        
        
        
    }
    
}
