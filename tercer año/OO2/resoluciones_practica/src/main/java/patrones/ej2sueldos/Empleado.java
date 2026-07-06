package patrones.ej2sueldos;

public abstract class Empleado {
    private boolean estaCasado;
    private int cantHijos;

    public Empleado(boolean estaCasado, int cantHijos){
        this.estaCasado=estaCasado;
        this.cantHijos=cantHijos;
    }


    public abstract int basico();



    protected int adicional(){
        int adicional = 2000 * cantHijos;
        if (estaCasado) adicional += 5000;
        return adicional;
    }

    public double descuento(){
        return (this.basico()*0.13) + (this.adicional()*0.05);
    }


    public double sueldo(){
        return this.basico() + this.adicional() - this.descuento();
    }


}
