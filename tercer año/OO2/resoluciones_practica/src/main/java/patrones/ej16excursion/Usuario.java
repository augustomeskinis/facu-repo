package patrones.ej16excursion;

public class Usuario {
    private String nombre;
    private String apellido;
    private String email;

    public Usuario (String nombre, String apellido, String email){
        this.nombre=nombre;
        this.apellido=apellido;
        this.email=email;
    }

    public String getEmail() {
        return email;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }
}
