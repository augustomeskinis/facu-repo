package patrones.ej17dispositivo;

public class Dispositivo {
    private CRC crc;
    private Connection connection;
    private Display display;
    private Ringer ringer;

    public String send (String data){
        long crc = this.crc.crcFor(data);
        return this.connection.sendData(data,crc);
    }

    public void cambiarConexion(Connection connection){
        this.connection=connection;
        this.display.showBanner(this.connection.pict());
        this.ringer.ring();
    }

    public void cambiarCRC(CRC crc){
        this.crc=crc;
    }


}
