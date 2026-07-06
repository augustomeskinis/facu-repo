package refactoring.ejercicio10.conRefactoring;

public class LlamadaNacional implements LLamadaStrategy {



    public double getMonto(double duracion) {
        return  duracion * 3 + (duracion * 3 * 0.21);
    }
}
