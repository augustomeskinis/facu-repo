package refactoring.ejercicio10.conRefactoring;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class GeneradorRandom  implements GeneradorStrategy {
    public String linea(TreeSet<String> lineas) {
        return new ArrayList<String>(lineas)
                .get(new Random().nextInt(lineas.size()));
    }
}
