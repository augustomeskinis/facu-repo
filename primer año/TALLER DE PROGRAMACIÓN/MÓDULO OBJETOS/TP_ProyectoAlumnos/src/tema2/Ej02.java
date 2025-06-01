/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author Augusto
 */
public class Ej02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int df = 15;
        Persona vector [] = new Persona [df];
        int dl = 0, i = 0; 
        String nombre = GeneradorAleatorio.generarString(20);
        int dni = GeneradorAleatorio.generarInt(100000);
        int edad = GeneradorAleatorio.generarInt(100);
        int cant = 0;
        int menorDni = 100001;
        int posicionMenorDNI = 0;
        
        while ( (edad != 0) && (dl < df) ) {
            vector[dl] = new Persona (nombre, dni, edad);
            dl++;
            nombre = GeneradorAleatorio.generarString(20);
            dni = GeneradorAleatorio.generarInt(100000);
            edad = GeneradorAleatorio.generarInt(100);
        }
        
        while (i < dl) {
            if (vector[i].getEdad() > 65) {
                cant++;
            }
            i++;
        }
        
        System.out.println("la cantidad de personas mayores de 65 años es: " + cant);
        
        i = 0;
        while (i < dl) {
            if (vector[i].getDNI() < menorDni) {
                menorDni = vector[i].getDNI();
                posicionMenorDNI = i;
            }
            i++;
        }
        
        System.out.println("Representación de la persona con menor dni: " + vector[posicionMenorDNI].toString());
        
        
        
    }
    
}
