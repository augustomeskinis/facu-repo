package parcialesViejos.parcial1.patrones;

public class PaqueteDecorator implements IPaquete {
    private IPaquete wrapper;

    public PaqueteDecorator (IPaquete wrapper){
        this.wrapper=wrapper;
    }

    @Override
    public String getDescripcion() {
        return this.wrapper.getDescripcion();
    }

    @Override
    public String getDestinatario() {
        return this.wrapper.getDestinatario();
    }

    @Override
    public String getDireccionDestino() {
        return this.wrapper.getDireccionDestino();
    }

    @Override
    public double getValorDeclarado() {
        return this.wrapper.getValorDeclarado();
    }

    @Override
    public double getCostoEnvio() {
        return this.wrapper.getCostoEnvio();
    }
}
