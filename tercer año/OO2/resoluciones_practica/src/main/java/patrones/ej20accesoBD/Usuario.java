package patrones.ej20accesoBD;

public class Usuario {
    private String nombre;
    private String contraseña;

    public Usuario (String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public boolean validarContraseña(String contraseña){
        return this.contraseña.equals(contraseña);
    }

    public String getNombre() {
        return nombre;
    }
}
