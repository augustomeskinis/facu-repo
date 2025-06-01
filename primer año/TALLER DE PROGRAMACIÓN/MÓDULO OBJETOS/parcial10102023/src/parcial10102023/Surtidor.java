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
public class Surtidor {
    private String combustible;
    private double precioPorLitro;
    private Venta vectorVentas [];
    private int dl;
    private int df;
    
    public Surtidor (String unCombustible, double unPrecio, int V){
        this.combustible = unCombustible;
        this.precioPorLitro = unPrecio;
        this.df = V;
        this.vectorVentas = new Venta [df];
    }
    
    public void generarVenta (int unDNI, int unaCant, String unMedio){
        if (dl<df){
            Venta V = new Venta (unDNI, unaCant, (unaCant*precioPorLitro), unMedio);
            vectorVentas[dl]=V;
            dl++;
        }
    }
    
    public double montoEnEfectivo () {
        double aux=0;
        for (int i=0; i<dl; i++){
            if (vectorVentas[i].getMedioPago()=="Efectivo"){
                aux += vectorVentas[i].getMontoAbonado();
            }
        }
        return aux;
    }
    
    public String toString () {
        String aux = " combustible dispensado: " + this.combustible + " ,precio por litro: " + this.precioPorLitro +"\n";
        for (int i=0;i<dl;i++){
            aux+= "  venta N" + (i+1) + vectorVentas[i].toString() + "\n";
        }
        return aux;
    }
    
    
    
    
    
    
    
    
    
}
