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
public class Bien {
    private String descripcion;
    private int cantidad;
    private int costoPorUnidad;
    
    public Bien(String unaDescripcion, int unaCantidad, int unCosto){
        this.descripcion=unaDescripcion;
        this.cantidad=unaCantidad;
        this.costoPorUnidad=unCosto;
    }
    
    public int costoFinal () {
        int aux = cantidad*costoPorUnidad;
        return aux;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
    
    
}
