package patrones.ej2sueldos;

public class EmpleadoPlanta extends Empleado {
    private int antiguedad;

    public EmpleadoPlanta (int cantHijos, boolean estaCasado, int antiguedad){
        super(estaCasado, cantHijos);
        this.antiguedad=antiguedad;
    }


    public int basico(){
        return 50000;
    }

    public int adicional(){
        return super.adicional() + (2000 * antiguedad);
    }
}
