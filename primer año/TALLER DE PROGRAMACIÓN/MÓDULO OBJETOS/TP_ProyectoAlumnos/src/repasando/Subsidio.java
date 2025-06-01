/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasando;

public class Subsidio {
    private double montoPedido;
    private String motivo;
    private boolean otorgado;
    
    public Subsidio (double unMonto, String unMotivo){
        montoPedido=unMonto;
        motivo=unMotivo;
        otorgado=false;
    }

    public double getMontoPedido() {
        return montoPedido;
    }

    public String getMotivo() {
        return motivo;
    }

    public boolean isOtorgado() {
        return otorgado;
    }

    public void setOtorgado(boolean otorgado) {
        this.otorgado = otorgado;
    }

    
}
