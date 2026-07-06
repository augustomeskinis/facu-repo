package patrones.ej15mensajero;

public class Main {
    public static void main(String[] args) {
        FeistelCipherAdapter feistelCipher = new FeistelCipherAdapter();
        Mensajero mensajero = new Mensajero(feistelCipher);
        mensajero.enviar("Hola!");

        RC4Adapter rc4 = new RC4Adapter("Contraseña");
        mensajero.setCifrado(rc4);
        mensajero.enviar("Hola!");
    }

}
