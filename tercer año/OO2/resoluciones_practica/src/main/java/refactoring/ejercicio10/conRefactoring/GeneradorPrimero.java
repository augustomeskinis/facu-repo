package refactoring.ejercicio10.conRefactoring;

import java.util.TreeSet;

public class GeneradorPrimero implements GeneradorStrategy {

    public String linea(TreeSet<String> lineas) {
        return lineas.first();
    }
}
