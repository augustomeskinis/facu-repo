package practica5.ejercicio5;

public class Jubilado extends Persona{
    private boolean cobro;

    public Jubilado (String nombre, String domicilio, boolean cobro){
        super(nombre, domicilio);
        this.cobro = cobro;
    }

    @Override
    public boolean esJubilado() {
        return true;
    }

    public boolean yaCobro(){
        return cobro;
    }

}
