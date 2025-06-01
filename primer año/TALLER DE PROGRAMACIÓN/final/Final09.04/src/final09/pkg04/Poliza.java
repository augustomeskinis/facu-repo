/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final09.pkg04;

/**
 *
 * @author Augusto
 */
public class Poliza {
    private int montoAsegurado;
    private double valorCuota;
    private Fecha comienzoCobertura;
    private Fecha finCobertura;
    private Cliente C;
    
    public Poliza (int unMonto, double unValor, Fecha unComienzo, Fecha unFin, Cliente unC){
        this.montoAsegurado = unMonto;
        this.valorCuota = unValor;
        this.comienzoCobertura = unComienzo;
        this.finCobertura = unFin;
        this.C = unC;
    }

    public void setValorCuota(double porcentaje) {
        this.valorCuota = valorCuota*porcentaje;
    }

    public Fecha getFinCobertura() {
        return finCobertura;
    }

    
    
    public int getDNI() {
        return C.getDNI();
    }

    @Override
    public String toString() {
        return "Poliza{" + "montoAsegurado=" + montoAsegurado + ", valorCuota=" 
                + valorCuota + ", comienzoCobertura=" + comienzoCobertura.toString()
                + ", finCobertura=" + finCobertura.toString() + ", C=" + C + '}';
    }
    
    
}
