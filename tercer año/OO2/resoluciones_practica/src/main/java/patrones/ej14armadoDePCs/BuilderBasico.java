package patrones.ej14armadoDePCs;

public class BuilderBasico extends PCBuilder {

    public BuilderBasico(Presupuesto p, Catalogo c) {
        super(p,c);
    }
    @Override
    public void setProcesador(){
        this.presupuesto.setProcesador(catalogo.getComponente("procesador basico"));
    }
    @Override
    public void setRAM(){
        this.presupuesto.setRAM(catalogo.getComponente("8 gb"));
    }
    @Override
    public void setDisco(){
        this.presupuesto.setDisco(catalogo.getComponente("HDD 500gb"));
    }
    @Override
    public void setTarjetaGrafica(){
        this.presupuesto.setTarjetaGrafica(catalogo.getComponente("radeon integrada"));
    }
    @Override
    public void setGabinete(){
        this.presupuesto.setGabinete(catalogo.getComponente("gabinete estandar"));
    }

}
