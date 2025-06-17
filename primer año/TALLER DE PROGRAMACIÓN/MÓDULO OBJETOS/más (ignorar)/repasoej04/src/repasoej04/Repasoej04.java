/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoej04;

/**
 *
 * @author Augusto
 */
public class Repasoej04 {

    public static void main(String[] args) {
        // TODO code application logic here
        Director d1 = new Director ("Juan",53453,39,50);
        CoroSemicircular c1 = new CoroSemicircular ("corito",d1,6);
        
        Corista a = new Corista("pepe",423424,30,8);
        Corista b = new Corista("augus",113424,30,7);
        Corista c = new Corista("coyo",212424,30,6);
        Corista d = new Corista("manu",978924,30,5);
        Corista e = new Corista("rama",345424,30,4);
        Corista f = new Corista("toro",4645424,30,3);
        
        c1.agregarCorista(a);
        c1.agregarCorista(b);
        c1.agregarCorista(c);
        c1.agregarCorista(d);
        c1.agregarCorista(e);
        c1.agregarCorista(f);
        
        System.out.println(c1.toString());
        System.out.println("esta lleno??"+c1.estaLleno());
        System.out.println("estan bien formados??"+c1.estaBienFormado());
        
        CoroHileras c2 = new CoroHileras ("corote",d1,3,2);
        c2.agregarCorista(a);
        c2.agregarCorista(b);
        c2.agregarCorista(c);
        c2.agregarCorista(d);
        c2.agregarCorista(e);
        c2.agregarCorista(f);
        System.out.println(c2.toString());
        System.out.println("esta lleno??"+c2.estaLleno());
        System.out.println("estan bien formados??"+c2.estaBienFormado());
    }
    
}
