/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Augusto
 */
public class Ej06 {

    public static void main(String[] args) {
       GeneradorAleatorio.iniciar();
       Estacion E = new Estacion("La Plata", -34.921, 57.955);
       SistemaAños sistemaA = new SistemaAños(E,2021,3);

       for (int i=0; i<3; i++){
           for(int j=0;j<12;j++){
               double temp = GeneradorAleatorio.generarDouble(110);
               sistemaA.registrarTemperatura(temp, 2021+i, j+1);
           }
       }
       System.out.println(sistemaA.toString());
       System.out.println(sistemaA.mayorTemperatura());
       
       
       
       Estacion E2 = new Estacion ("Mar del Plata",-38.002,-57.556);
       SistemaMeses sistemaM = new SistemaMeses(E2,2020,4);
       
       for (int i=0; i<4; i++){
           for(int j=0;j<12;j++){
               double temp = GeneradorAleatorio.generarDouble(110);
               sistemaM.registrarTemperatura(temp, 2020+i, j+1);
           }
       }
       
       System.out.println(sistemaM.toString());
       System.out.println(sistemaM.mayorTemperatura());

        
    }
    
}
