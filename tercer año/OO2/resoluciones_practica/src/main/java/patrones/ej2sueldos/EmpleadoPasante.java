package patrones.ej2sueldos;

public class EmpleadoPasante extends Empleado {

    public EmpleadoPasante(int cantHijos, boolean estaCasado){
        super(estaCasado, cantHijos);
    }

    public int basico(){
        return 20000;
    }

    @Override
    public int adicional(){
        return 2000;
    }

}
