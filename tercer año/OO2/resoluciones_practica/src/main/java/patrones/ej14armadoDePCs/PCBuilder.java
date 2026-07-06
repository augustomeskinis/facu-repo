package patrones.ej14armadoDePCs;

public abstract class PCBuilder {
    protected Presupuesto presupuesto;
    protected Catalogo catalogo;

    public PCBuilder(Presupuesto p, Catalogo c){
        this.reset(p,c);
    }

    public void reset(Presupuesto p, Catalogo c){
        this.presupuesto=p;
        this.catalogo=c;
    }

    public abstract void setProcesador();
    public abstract void setRAM();
    public abstract void setDisco();
    public abstract void setTarjetaGrafica();
    public abstract void setGabinete();


    public Presupuesto getPresupuesto (){
        return this.presupuesto;
    }

}
