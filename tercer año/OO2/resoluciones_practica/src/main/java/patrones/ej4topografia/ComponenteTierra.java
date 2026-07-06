package patrones.ej4topografia;

public class ComponenteTierra extends Componente{

    public ComponenteTierra(){
        this.proporcion=0;
    }

    @Override
    public double getProporcion() {
        return this.proporcion;
    }

}
