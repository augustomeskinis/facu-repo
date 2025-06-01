/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial10102023;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author Augusto
 */
public class Parcial10102023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneradorAleatorio.iniciar();
        Estacion est = new Estacion("La Plata");
        Surtidor surt1 = new Surtidor("Super", 300.0, 500);
        Surtidor surt2 = new Surtidor("Ultra Diesel", 200.0, 400);
        
        est.agregarSurtidor(surt1);
        est.agregarSurtidor(surt2);
        
        est.agregarVenta(1, GeneradorAleatorio.generarInt(30)+1, GeneradorAleatorio.generarInt(50)+100, "Debito");
        est.agregarVenta(1, GeneradorAleatorio.generarInt(30)+1, GeneradorAleatorio.generarInt(50)+100, "Credito");
        est.agregarVenta(2, GeneradorAleatorio.generarInt(30)+1, GeneradorAleatorio.generarInt(50)+100, "Debito");
        est.agregarVenta(2, GeneradorAleatorio.generarInt(30)+1, GeneradorAleatorio.generarInt(50)+100, "Efectivo");
        est.agregarVenta(2, GeneradorAleatorio.generarInt(30)+1, GeneradorAleatorio.generarInt(50)+100, "Debito");
        
        System.out.println(est.toString());
        System.out.println("El numero del surtidor que recaudo el mayor monto total es: " + est.surtidorMayor());
    }
    
}
