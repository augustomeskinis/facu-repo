package parcialesViejos.parcial1.patrones;

public class Paquete implements IPaquete {
    private String descripcion;
    private String destinatario;
    private String direccionDestino;
    private double valorDeclarado;

    public Paquete(String descripcion, String destinatario, String direccionDestino, double valorDeclarado) {
        this.descripcion = descripcion;
        this.destinatario = destinatario;
        this.direccionDestino = direccionDestino;
        this.valorDeclarado = valorDeclarado;
    }


    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String getDestinatario() {
        return destinatario;
    }

    @Override
    public String getDireccionDestino() {
        return direccionDestino;
    }

    @Override
    public double getValorDeclarado() {
        return valorDeclarado;
    }

    public double getCostoEnvio(){
        return valorDeclarado * 0.05;
    }
}
