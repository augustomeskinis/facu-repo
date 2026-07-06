package patrones.ej14armadoDePCs;

public class Componente {
    private String nombre;
    private String descripcion;
    private double precio;
    private double consumo;

    public Componente (String nombre, String descripcion, double precio, double consumo){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.consumo = consumo;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
