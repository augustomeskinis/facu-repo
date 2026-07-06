package patrones.ej15mensajero;

public class Mensajero {
    private Cifrado cifrado;

    public Mensajero (Cifrado cifrado){
        this.cifrado=cifrado;
    }

    public void setCifrado(Cifrado c){
        this.cifrado=c;
    }

    public void enviar (String mensaje){
        this.cifrado.encriptar(mensaje);
    }

    public void recibir (String mensaje){
        this.cifrado.desencriptar(mensaje);
    }
}
