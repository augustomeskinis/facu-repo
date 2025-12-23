package grafos.parcial2;

import java.util.LinkedList;
import java.util.List;

public class CaminoConDistancia {
    private List<String> camino;
    private int distancia;

    public void setCamino(List<String>nuevo){
        this.camino = new LinkedList<>(nuevo);
    }

    public void setDistancia (int nueva){
        this.distancia = nueva;
    }
}
