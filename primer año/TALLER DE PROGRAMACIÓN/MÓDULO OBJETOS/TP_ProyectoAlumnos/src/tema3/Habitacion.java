
package tema3;
import PaqueteLectura.GeneradorAleatorio;
public class Habitacion {
    private int costoPorNoche;
    private boolean ocupada;
    private Persona cliente;
    
    public Habitacion (){
        this.ocupada = false;
        GeneradorAleatorio.iniciar();
        costoPorNoche = GeneradorAleatorio.generarInt(6000)+2000;
     
    }
    
    public void reservarHabitacion(Persona C){
        cliente = C;
        ocupada = true;
    }    
    
    
    public void aumentarCosto (int monto){
        this.costoPorNoche += monto;
    }

    public int getCostoPorNoche() {
        return costoPorNoche;
    }
    
    
    
    
    public String getEstado () {
        String aux = "Libre";
        if (this.ocupada == true) {
            aux = "Ocupada, cliente: "+this.cliente.toString();
        }
        return aux;
    }
    
}
