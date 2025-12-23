package árboles.parcial3;

public class Derivador {
    private String nombre;
    private boolean activo;

    public Derivador (String nombre, boolean activo){
        this.nombre = nombre;
        this.activo = activo;
    }

    public String getNombre(){
        return this.nombre;
    }

    public boolean isActivo(){
        return this.activo;
    }
}
