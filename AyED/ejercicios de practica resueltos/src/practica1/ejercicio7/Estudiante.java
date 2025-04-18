package practica1.ejercicio7;

public class Estudiante {
    private String nombre;
    private String apellido;
    private int comision;
    private String email;
    private String direccion;

    public Estudiante(String nombre, String apellido, int comision,
                      String email, String direccion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.comision = comision;
        this.email = email;
        this.direccion = direccion;
    }

    public String tusDatos (){
        return this.getApellido()
                + this.getNombre() + "/n"
                +this.getDireccion() + "/n"
                +this.getEmail() + "/n"
                +this.getComision() + "/n"
                +this.getDireccion() + "/n" ;

    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
