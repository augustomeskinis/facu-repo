package repaso.ejercicio2;

public abstract class Objeto {
    private String nombre;

    public Objeto (String nombre) {
        this.nombre=nombre;
    }

    public abstract void jugar (String objeto);

    public String getNombre(){
        return nombre;
    }

}
