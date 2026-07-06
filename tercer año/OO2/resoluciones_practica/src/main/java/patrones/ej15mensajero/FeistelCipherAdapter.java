package patrones.ej15mensajero;

public class FeistelCipherAdapter extends Cifrado {

    private FeistelCipher feistelCipher;

    @Override
    public String encriptar(String mensaje){
        return this.feistelCipher.encode(mensaje);
    }

    @Override
    public String desencriptar(String mensaje){
        return this.feistelCipher.encode(mensaje);
    }

}
