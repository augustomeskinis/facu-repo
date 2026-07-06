package patrones.ej2sueldos;

public class EmpleadoTemporario extends Empleado {
    private int cantHoras;


    public EmpleadoTemporario(int cantHoras, int cantHijos, boolean estaCasado){
        super(estaCasado, cantHijos);
        this.cantHoras=cantHoras;
    }

    public int basico(){
        return 20000 + (cantHoras*300);
    }

    public int adicional(){
        return super.adicional();
    }

}
