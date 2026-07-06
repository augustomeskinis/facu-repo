package patrones.ej4topografia;

public class ComponenteAgua extends Componente {

    public ComponenteAgua (){
        this.proporcion=1;
    }

    @Override
    public double getProporcion() {
        return this.proporcion;
    }
}
