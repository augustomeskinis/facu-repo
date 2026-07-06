package patrones.ej14armadoDePCs;

public class BuilderIntermedio extends PCBuilder {

    public BuilderIntermedio(Presupuesto p, Catalogo c) {
        super(p,c);
    }
    @Override
    public void setProcesador(){
        this.presupuesto.setProcesador(catalogo.getComponente("procesador intermedio"));
    }
    @Override
    public void setRAM(){
        this.presupuesto.setRAM(catalogo.getComponente("16 gb"));
    }
    @Override
    public void setDisco(){
        this.presupuesto.setDisco(catalogo.getComponente("SSD 500gb"));
    }
    @Override
    public void setTarjetaGrafica(){
        this.presupuesto.setTarjetaGrafica(catalogo.getComponente("GTX 1650"));
    }
    @Override
    public void setGabinete(){
        this.presupuesto.setGabinete(catalogo.getComponente("gabinete intermedio, fuente 800w"));
    }

}
