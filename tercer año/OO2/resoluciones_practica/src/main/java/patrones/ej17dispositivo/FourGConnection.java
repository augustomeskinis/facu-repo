package patrones.ej17dispositivo;

public class FourGConnection {
    private String symb;

    public FourGConnection() {
        this.symb = "4G";
    }

    public String transmit (String data, long crc) {
        return "4G: " + data + " " + crc;
    }

    public String symb() {
        return this.symb;
    }
}
