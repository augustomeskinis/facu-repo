package grafos.parcial1;
import clases.Edge;
import clases.Graph;
import clases.Vertex;
import java.util.LinkedList;
import java.util.List;

public class ParcialGrafos {

    public List<String> rutaOptimaDistribucion(Graph<String> reino, String castillo, String aldea, int maxPociones) {
        List<String> caminoActual = new LinkedList<>();
        List<String> caminoMax = new LinkedList<>();
        if (reino != null && !reino.isEmpty()) {
            Vertex<String> vCastillo = reino.search(castillo);
            Vertex<String> vAldea = reino.search(aldea);

            if (vCastillo != null && vAldea != null) {
                int pos = vCastillo.getPosition();
                boolean[] marca = new boolean[reino.getSize()];
                recorrido(reino,vCastillo, pos, aldea, marca,0, maxPociones, caminoActual, caminoMax);
            }
        }
        return caminoMax;
    }


    public void recorrido (Graph<String> reino,Vertex<String> vActual, int i, String destino, boolean [] marca, int cant,
                           int maxPociones, List<String> caminoActual, List<String> caminoMax){
        marca[i] = true;
        String ciudadActual = vActual.getData();
        caminoActual.add(ciudadActual);

        if (ciudadActual.equals(destino)){
            if (caminoActual.size() > caminoMax.size()) {
                caminoMax.clear();
                caminoMax.addAll(caminoActual);
            }
        }
        else {
            for (Edge<String> edge : reino.getEdges(vActual)){
                int nuevaCant = cant + edge.getWeight();
                int j = edge.getTarget().getPosition();

                if (!marca[j] && nuevaCant<=maxPociones){
                    recorrido(reino, edge.getTarget(),j,destino,marca,cant,maxPociones,caminoActual,caminoMax);
                }
            }
        }
        caminoActual.removeLast();
        marca[i]=false;
    }
}