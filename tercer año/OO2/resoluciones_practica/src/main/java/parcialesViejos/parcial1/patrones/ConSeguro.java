package parcialesViejos.parcial1.patrones;

public class ConSeguro extends PaqueteDecorator{

    public ConSeguro(IPaquete wrapper) {
        super(wrapper);
    }

    public String getDescripcion(){
        return super.getDescripcion() + " con seguro ";
    }

    @Override
    public double getCostoEnvio() {
        return super.getCostoEnvio() + this.getValorDeclarado() * 0.2;
    }

}
