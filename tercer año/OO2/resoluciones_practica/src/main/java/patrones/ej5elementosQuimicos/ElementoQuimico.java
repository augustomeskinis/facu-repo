package patrones.ej5elementosQuimicos;

public abstract class ElementoQuimico {

    public abstract double pesoAtomico();

    public abstract double cargaElectrica();

    public abstract boolean esMetal();

    public boolean esNoMetal(){
        return !this.esMetal();
    }

    public abstract String formula();

    public abstract boolean esValida();


}