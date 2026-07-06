package refactoring.ejercicio10.conRefactoring;

import java.util.TreeSet;

public class GeneradorUltimo implements GeneradorStrategy {

    @Override
    public String linea(TreeSet<String> lineas) {
        return lineas.last();
    }
}
