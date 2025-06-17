/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialz;

/**
 *
 * @author Augusto
 */
public class ParcialZ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SubsidioDeEstadia S1 = new SubsidioDeEstadia("Juan","programador",18.07,"Bariloche",300,12,500);
        System.out.print(S1.toString());
        
        SubsidioDeBienes S2 = new SubsidioDeBienes("Pedro","costurero",23.10,2);
        Bien B1 = new Bien ("auto usado",3,12500);
        Bien B2 = new Bien ("casa vieja",1,10000);
        S2.agregarBien(B1);
        S2.agregarBien(B2);
        System.out.println(S2.toString());
    }
    
}
