package patrones.ej5elementosQuimicos;

public class Hidrogeno extends ElementoQuimico{
    public double pesoAtomico() {
        return 1;
    }

    public double cargaElectrica() {
        return 1;
    }

    public boolean esMetal() {
        return false;
    }

    public String formula() {
        return "H";
    }

    public boolean esValida(){
        return true;
    }
}
