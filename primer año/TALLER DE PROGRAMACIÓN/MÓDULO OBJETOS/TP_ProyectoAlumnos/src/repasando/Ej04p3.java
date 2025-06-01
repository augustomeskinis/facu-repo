/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasando;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author Augusto
 */
public class Ej04p3 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona matriz [][]= new Persona[5][8];
        int dimL [] = new int [8];
        int dimLMatriz = 0;
        
        
        System.out.println("ingrese su nombre");
        String nombre = Lector.leerString();       

        
        while ((dimLMatriz <40) && !(nombre.equals("ZZZ"))){
            System.out.println("ingrese el dia que se quiere inscribir");
            int dia = Lector.leerInt();
            int DNI=GeneradorAleatorio.generarInt(100000);
            int edad=GeneradorAleatorio.generarInt(100);
            
            if (dimL[(dia-1)]<8) {
                matriz[(dia-1)][dimL[(dia-1)]]= new Persona(nombre,DNI,edad);
                dimL[(dia-1)]++;
            }
            else {
                System.out.println("no hay mas cupos en el dia " + dia);
            }
            dimLMatriz ++;
            System.out.println("ingrese su nombre");
            nombre = Lector.leerString();
        }
        
        for(int i=0;i<5;i++){
            System.out.println("inscriptos en el dia " + (i+1) + ": " + dimL[i]);
            for(int j=0; j<dimL[i]; j++){
                System.out.println(matriz[i][j].getNombre());
            }
        }
    }
    
}
