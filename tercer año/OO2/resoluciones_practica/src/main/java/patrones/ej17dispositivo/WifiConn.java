package patrones.ej17dispositivo;

public class WifiConn implements Connection {

    private String pict;

    public WifiConn() {
        this.pict = "Wifi";
    }

    public String sendData(String data, long crc) {
        return "Wifi: " + data + " " + crc;
    }

    public String pict() {
        return this.pict;
    }


}
