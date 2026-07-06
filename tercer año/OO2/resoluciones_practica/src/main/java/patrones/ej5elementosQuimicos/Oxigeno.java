package patrones.ej5elementosQuimicos;

public class Oxigeno extends ElementoQuimico {

    public double pesoAtomico() {
        return 16;
    }

    public double cargaElectrica() {
        return -2;
    }

    public boolean esMetal() {
        return false;
    }

    public String formula() {
        return "O";
    }

    public boolean esValida(){
        return true;
    }
}