/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Alumno
 */
public class MainVisorFiguras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        VisorFiguras visor = new VisorFiguras();
 
 Cuadrado c1 = new Cuadrado(10,"Violeta","Rosa");
 Rectangulo r= new Rectangulo(20,10,"Azul","Celeste");
 Cuadrado c2= new Cuadrado(30,"Rojo","Naranja");
 
 visor.mostrar(c1);
 visor.mostrar(r);
 visor.mostrar(c2);
 
 System.out.println(visor.getMostradas());
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
