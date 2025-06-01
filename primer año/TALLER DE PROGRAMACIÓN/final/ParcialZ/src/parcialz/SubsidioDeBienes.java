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
public class SubsidioDeBienes extends Subsidio {
    private int dl=0;
    private int df;
    private Bien [] vector; // java inicializa en null
    
    public SubsidioDeBienes (String unNombre, String unPlan, double unaFecha, int N){
        super(unNombre,unPlan,unaFecha);
        this.df=N;
        vector = new Bien [df];
    }
    
    public void agregarBien(Bien B){
        if (dl < df) {
            vector[dl]=B;
            dl++;
        }
        else {
            System.out.println("No se pudo agregar el bien pq llegaste al máximo");
        }
    }
    
    public int montoTotal () {
        int aux=0;
        for (int i=0; i<dl; i++){
            aux += vector[i].costoFinal();
        }
        return aux;
    }
    public String toString () {
        String aux = "\n" + super.toString();
        aux+= "\n" +"Descripcion de los bienes solicitados: " ;
        for(int i=0; i<dl; i++){
            aux+= "\n" + "Descripción bien " + (i+1) +": "+vector[i].getDescripcion();
        }
        return aux;
    }
}
