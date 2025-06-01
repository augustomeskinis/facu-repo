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
public abstract class Subsidio {
    private String nombreInvestigador;
    private String planTrabajo;
    private double fechaSolicitud;
    
    public Subsidio (String unNombre, String unPlan, double unaFecha) {
        this.nombreInvestigador = unNombre;
        this.planTrabajo = unPlan;
        this.fechaSolicitud = unaFecha;
    }
    
    
    public abstract int montoTotal();
    
    public String toString () {
        String aux;
        aux = "Nombre del investigador: " + nombreInvestigador +", Plan de trabajo: " + planTrabajo 
                + ", fecha de solicitud: " + fechaSolicitud + "\n" + "Monto total: " + this.montoTotal() 
                 + "\n" ;
        return aux;
    }
    
    
}
