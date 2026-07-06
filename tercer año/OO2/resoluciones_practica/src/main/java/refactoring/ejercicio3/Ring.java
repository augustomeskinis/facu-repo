package refactoring.ejercicio3;

public abstract class Ring {
    protected int idx;

    public Ring() {
        this.idx = 0;
    }

    protected void resetIfNeeded(int length) {
        if (idx >= length)
            idx = 0;
    }
}
