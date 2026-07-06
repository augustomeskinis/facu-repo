package refactoring.ejercicio10.conRefactoring;

public  class Llamada {
    private String origen;
    private String destino;
    private int duracion;
    private LLamadaStrategy strategy;

    public Llamada(String origen, String destino, int duracion, LLamadaStrategy strategy) {
        this.origen= origen;
        this.destino= destino;
        this.duracion = duracion;
        this.strategy=strategy;
    }

    public void setStrategy(LLamadaStrategy strategy) {
        this.strategy = strategy;
    }

    public double getMonto(){
        return this.strategy.getMonto(this.duracion);
    }

    public String getRemitente() {
        return destino;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public String getOrigen() {
        return origen;
    }
}
