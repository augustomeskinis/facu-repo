package refactoring.ejercicio10.conRefactoring;

import java.util.SortedSet;
import java.util.TreeSet;

public class GestorNumerosDisponibles {
    private SortedSet<String> lineas = new TreeSet<String>();
    private GeneradorStrategy strategy = new GeneradorUltimo();

    public boolean agregarNumerosDeTelefono(String nro){
        if (!this.lineas.contains(nro)){
            this.lineas.add(nro);
            return true;
        }
        return false;
    }

    public String obtenerNumeroLibre(){
        String linea = this.strategy.linea((TreeSet<String>) lineas);
        lineas.remove(linea);
        return linea;
    }

    public void setStrategy(GeneradorStrategy strategy) {
        this.strategy = strategy;
    }

}
