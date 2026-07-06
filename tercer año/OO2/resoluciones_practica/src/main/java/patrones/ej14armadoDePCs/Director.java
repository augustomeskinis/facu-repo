package patrones.ej14armadoDePCs;

public class Director {
    private PCBuilder builder;

    public Director (PCBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder (PCBuilder builder) {
        this.builder = builder;
    }

    public Presupuesto build (String nombre) {
        this.builder.reset(new Presupuesto(),new Catalogo());
        this.builder.setProcesador();
        this.builder.setRAM();
        this.builder.setDisco();
        this.builder.setTarjetaGrafica();
        this.builder.setGabinete();
        return this.builder.getPresupuesto();
    }
}
