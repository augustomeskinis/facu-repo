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
public class Ej05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Partido vector [] = new Partido [20];
        int dl = 0;
        String local; String visitante; int golesLocal; int golesVisitante;
        
        
        System.out.println("ingrese el visitante");
        visitante = Lector.leerString();
        
        while ((dl<20) && (!(visitante.equals("ZZZ") ) ) ) {
            System.out.println("ingrese el local");
            local = Lector.leerString();
            System.out.println("ingrese los goles de local");
            golesLocal = Lector.leerInt();
            System.out.println("ingrese los goles de visitante");
            golesVisitante = Lector.leerInt();
            vector[dl] = new Partido (local, visitante, golesLocal, golesVisitante);
            dl ++;
            System.out.println("ingrese el visitante");
            visitante = Lector.leerString();
        }
        
        int i; int cant=0; int cant2=0;
        
        for (i=0; i<dl ; i++) { 
            System.out.println(vector[i].toString());
            if(vector[i].getGanador().equals("River")) {
                cant++;
            }
            if(vector[i].getLocal().equals("Boca")){
                cant2 += vector[i].getGolesLocal();
            }
        }
        System.out.println("River ganó: "+ cant +" partidos.");
        System.out.println("Boca metió "+cant+" goles de local.");
        
    }
    
}
