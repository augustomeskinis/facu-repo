package grafos.parcial4_desaprobado_18_11_2025;

public class Par {
    String origen;
    String destino;
    int distancia;


    public Par(String origen, String destino, int distancia){
        this.origen=origen;
        this.destino=destino;
        this.distancia=distancia;
    }

    public void setOrigen(String origen){
        this.origen=origen;
    }

    public void setDestino(String destino){
        this.destino=destino;
    }

    public void setDistancia(int distancia){
        this.distancia=distancia;
    }

    public String getOrigen(){
        return this.origen;
    }


    public String getDestino(){
        return this.destino;
    }

    public int getDistancia(){
        return this.distancia;
    }
}
