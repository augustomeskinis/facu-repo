package practica5.ejercicio5;

public abstract class Persona {
    private String nombre;
    private String domicilio;

    public Persona (String nombre, String domicilio){
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    public abstract boolean esJubilado();

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }
}
