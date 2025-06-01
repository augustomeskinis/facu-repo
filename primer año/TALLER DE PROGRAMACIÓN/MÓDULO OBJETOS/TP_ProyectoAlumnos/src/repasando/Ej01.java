/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasando;

/**
 *
 * @author Augusto
 */
public class Ej01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Subsidio s = new Subsidio(345, "que se yo");
        Subsidio s2 = new Subsidio(390, " no se");
        Subsidio s3 = new Subsidio(700, "que se yo");
        Subsidio s4 = new Subsidio(10090, " no se");
        Subsidio s6 = new Subsidio(345, "que se yo");
        Subsidio s5 = new Subsidio(390, " no se");
        
        
        Investigador i = new Investigador("Juan carlos",2,"sociales");
        i.agregarSubsidio(s);i.agregarSubsidio(s2);
        Investigador i2 = new Investigador("Pepe sanches",3,"economicas");
        i2.agregarSubsidio(s3);i2.agregarSubsidio(s4);
        Investigador i3 = new Investigador("Augusto jose",4,"artes");
        i3.agregarSubsidio(s5);i3.agregarSubsidio(s6);
        
        Proyecto P = new Proyecto ("Probando",1234,"Juan Perez");
        P.agregarInvestigador(i);
        P.agregarInvestigador(i2);
        P.agregarInvestigador(i3);
        
        P.otorgarTodos("Juan carlos");
        P.otorgarTodos("Pepe sanches");
        System.out.println(P.toString());
        
    }
    
}
