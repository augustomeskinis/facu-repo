/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final09.pkg04;
import PaqueteLectura.Lector;
/**
 *
 * @author Augusto
 */
public class Final0904 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Fecha f1 = new Fecha (01,04,2024);
        Fecha f2 = new Fecha (01,02,2024);
        
        Cliente c1 = new Cliente (1,"juan","perez");
        Cliente c2 = new Cliente (2,"augusto","meskinis");
        Cliente c3 = new Cliente (3,"leo","messi");
        
        Poliza p1 = new Poliza (100,200,f1,f2,c1);
        Poliza p2 = new Poliza (100,300,f2,f1,c1);
        Poliza p3 = new Poliza (100,400,f1,f2,c2);
        Poliza p4 = new Poliza (100,500,f2,f1,c2);
        Poliza p5 = new Poliza (100,600,f1,f2,c1);
        
        Sistema s = new Sistema();
        s.agregarPoliza(p1, 2);
        s.agregarPoliza(p2, 3);
        s.agregarPoliza(p3, 3);
        s.agregarPoliza(p4, 4);
        s.agregarPoliza(p5, 5);
        
        System.out.println("INGRESE UN DNI: ");
        int unDNI = Lector.leerInt();
        System.out.println(s.infoCliente(unDNI));
        
        s.aumentarCuotas(1.11, 3);
        
        System.out.println("CANTIDAD DE POLIZAS QUE VENCEN EN ABRIL DE 2024: " + s.cantidadAVencer(04,2024));
        
    }
    
}
