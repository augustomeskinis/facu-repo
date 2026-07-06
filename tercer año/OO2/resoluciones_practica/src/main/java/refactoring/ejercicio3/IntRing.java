package refactoring.ejercicio3;

public class IntRing extends Ring {
    private int[] source;

    public IntRing(int[] src) {
        source = src;
    }

    public int next() {
        resetIfNeeded(source.length);
        return source[idx++];
    }
}

