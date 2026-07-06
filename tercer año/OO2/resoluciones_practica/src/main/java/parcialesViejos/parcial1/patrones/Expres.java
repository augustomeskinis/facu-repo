package parcialesViejos.parcial1.patrones;

public class Expres extends PaqueteDecorator {

    public Expres (IPaquete wrapper) {
        super(wrapper);
    }

    @Override
    public double getCostoEnvio() {
        return this.getValorDeclarado()*0.5 + super.getCostoEnvio();
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + "entrega expres";
    }
}
