package parcialesViejos.parcial1.patrones;

public class ConSeguimiento extends PaqueteDecorator {

    public ConSeguimiento(IPaquete wrapper) {
        super(wrapper);
    }

    @Override
    public double getCostoEnvio() {
        return super.getCostoEnvio() + 2000;
    }
}
