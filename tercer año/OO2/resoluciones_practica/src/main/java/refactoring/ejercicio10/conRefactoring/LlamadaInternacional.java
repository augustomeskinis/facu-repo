package refactoring.ejercicio10.conRefactoring;

public class LlamadaInternacional implements LLamadaStrategy {


    public double getMonto(double duracion ) {
        return duracion * 150 + (duracion * 150 * 0.21) + 50;
    }
}
