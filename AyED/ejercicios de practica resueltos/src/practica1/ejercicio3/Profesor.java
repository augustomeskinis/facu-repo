package practica1.ejercicio3;

public class Profesor {
    private String nombre;
    private String apellido;
    private String email;
    private int catedra;
    private String facultad;

    public Profesor (String nombre, String apellido, String email,
                    int catedra, String facultad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.catedra = catedra;
        this.facultad = facultad;
    }



    public String tusDatos (){
        return this.nombre +
                this.getApellido() + "/n"+
                this.getNombre() + "/n" +
                this.getCatedra() + "/n" +
                this.getEmail() + "/n" +
                this.getFacultad() + "/n" ;
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
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public int getCatedra() {
        return catedra;
    }

    public void setCatedra(int catedra) {
        this.catedra = catedra;
    }
}
