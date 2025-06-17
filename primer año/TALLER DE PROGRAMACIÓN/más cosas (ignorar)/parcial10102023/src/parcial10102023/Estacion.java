/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial10102023;

/**
 *
 * @author Augusto
 */
public class Estacion {
    private String direccion;
    private Surtidor vectorSurtidores [];
    private int dl=0;
    private int df ;
    
    public Estacion (String unaDireccion){
        this.direccion = unaDireccion;
        this.df = 6;
        this.vectorSurtidores = new Surtidor [df];
    }
    
    public void agregarSurtidor (Surtidor S){
        if (dl<df) {
            vectorSurtidores[dl] = S;
            dl++;
        }
    }
    public void agregarVenta (int N, int unDNI, int unaCant, String unMedio){
        vectorSurtidores[N-1].generarVenta(unDNI,unaCant,unMedio);
        
    }
    
    public int surtidorMayor (){
        int maxSurtidor = -1; double maxMonto = -1;
        for (int i=0; i<dl; i++){
            if(vectorSurtidores[i].montoEnEfectivo() > maxMonto){
                maxMonto = vectorSurtidores[i].montoEnEfectivo();
                maxSurtidor = i;
            }
        }
        return (maxSurtidor+1);
        
    }
    public String toString () {
        String aux = "Estacion de servicio: " + this.direccion + ", Cantidad de surtidores: " + this.dl + "\n";
        for(int i=0; i<this.dl;i++){
            aux+= "Surtidor " + (i+1) + vectorSurtidores[i].toString() + "\n";
        }
        return aux;
    }
    
}
