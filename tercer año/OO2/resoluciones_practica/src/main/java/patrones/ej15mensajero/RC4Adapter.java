package patrones.ej15mensajero;

public class RC4Adapter extends Cifrado {
    private RC4 rc4;
    private String key;

    public RC4Adapter(String key){
        this.rc4 = new RC4();
        this.key = key;
    }

    @Override
    public String encriptar(String mensaje) {
        return this.rc4.encriptar(mensaje,this.key);
    }

    @Override
    public String desencriptar(String mensaje) {
        return this.rc4.desencriptar(mensaje,this.key);
    }
}
