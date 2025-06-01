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
public class SubsidioDeEstadia extends Subsidio {
    private String lugarDestino;
    private int costoEnPasajes;
    private int cantDias;
    private int montoHotel;
    
    public SubsidioDeEstadia (String unNombre, String unPlan, double unaFecha, String unLugar,
                                int unCosto, int unaCant, int unMonto){
        super(unNombre,unPlan,unaFecha);
        this.lugarDestino=unLugar;
        this.costoEnPasajes=unCosto;
        this.cantDias=unaCant;
        this.montoHotel=unMonto;
    }
    
    public int montoTotal () {
        int aux;
        aux = costoEnPasajes + (cantDias * montoHotel);
        return aux;
    }
    
    public String toString () {
        String aux=super.toString();
        aux += "Lugar de destino: " + lugarDestino + ", Dias de estadia: " + cantDias;
        return aux;
    }
    
}
