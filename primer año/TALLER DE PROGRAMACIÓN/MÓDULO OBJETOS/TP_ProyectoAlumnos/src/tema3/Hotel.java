
package tema3;

/**
 *
 * @author Augusto
 */
public class Hotel {
    private Habitacion vector [];
    private int df;
    
    public Hotel (int N) {
        df = N;
        vector = new Habitacion [df];
        for (int i = 0; i<df; i++){
            vector[i] = new Habitacion();
        }
    }
    
    public void agregarCliente (Persona C, int X) {
        vector[X-1].reservarHabitacion(C);
        
    }
    
    public void aumentarHabitaciones (int monto) {
        for (int i = 0; i<df; i++){
            vector[i].aumentarCosto(monto);
        }
    }
    
    public String toString (){
        String aux="";
        for (int i = 0; i<df; i++) {
            aux += " Habitacion numero: " + (i+1) + " costo: " +vector[i].getCostoPorNoche()
                    + " Estado: " +vector[i].getEstado(); // ESTA BIEN EL METEDO vector[i].getEstado() ??
            
         }
        
        return aux;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
