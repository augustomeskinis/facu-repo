package patrones.ej17dispositivo;

public class FoutGConnectionAdapter implements Connection {
    private FourGConnection fourGConnection;

    @Override
    public String sendData(String data, long crc) {
        return this.fourGConnection.transmit(data,crc);
    }

    @Override
    public String pict() {
        return this.fourGConnection.symb();
    }
}
