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
public class Venta {
    private int DNIcliente;
    private int cantLitros;
    private double montoAbonado;
    private String medioPago;
    
    public Venta(int unDNI, int unaCant, double unMonto, String unMedio){
        this.DNIcliente = unDNI;
        this.cantLitros = unaCant;
        this.montoAbonado = unMonto;
        this.medioPago = unMedio;
    }

    public double getMontoAbonado() {
        return montoAbonado;
    }

    public String getMedioPago() {
        return medioPago;
    }

    @Override
    public String toString() {
        return "  DNIcliente=" + DNIcliente + ", cantLitros=" + cantLitros + ", montoAbonado=" + montoAbonado + ", medioPago=" + medioPago + '}';
    }

    
}
