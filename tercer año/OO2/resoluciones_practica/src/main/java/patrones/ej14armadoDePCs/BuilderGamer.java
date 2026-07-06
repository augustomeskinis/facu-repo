package patrones.ej14armadoDePCs;

public class BuilderGamer extends PCBuilder {

    public BuilderGamer (Presupuesto p, Catalogo c) {
        super(p,c);
    }
    @Override
    public void setProcesador(){
        this.presupuesto.setProcesador(catalogo.getComponente("procesador gamer"));
    }
    @Override
    public void setRAM(){
        this.presupuesto.setRAM(catalogo.getComponente("64gb"));
    }
    @Override
    public void setDisco(){
        this.presupuesto.setDisco(catalogo.getComponente("SSD 500gb, SSD 1TB"));
    }
    @Override
    public void setTarjetaGrafica(){
        this.presupuesto.setTarjetaGrafica(catalogo.getComponente("RTX 4090"));
    }
    @Override
    public void setGabinete(){
        this.presupuesto.setGabinete(catalogo.getComponente("gabinete gamer, fuente: " + this.presupuesto.calcularConsumo()*1.5 + "w"));
    }



}
