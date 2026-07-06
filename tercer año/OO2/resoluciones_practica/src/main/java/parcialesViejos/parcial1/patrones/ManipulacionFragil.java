package parcialesViejos.parcial1.patrones;

public class ManipulacionFragil extends PaqueteDecorator {

    public ManipulacionFragil(IPaquete wrapper) {
        super(wrapper);
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " fragil ";
    }
}
