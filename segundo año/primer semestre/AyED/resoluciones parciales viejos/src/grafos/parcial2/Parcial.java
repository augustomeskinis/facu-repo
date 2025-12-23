package grafos.parcial2;

import clases.Edge;
import clases.Graph;
import clases.Vertex;

import java.util.LinkedList;
import java.util.List;

public class Parcial {

    public List<CaminoConDistancia> resolver(Graph<String> sitios, String origen, String destino, List<String> evitarPasarPor) {

        List<CaminoConDistancia> caminos = new LinkedList<>();

        if (sitios != null && !sitios.isEmpty()) {

            Vertex<String> vOrigen = sitios.search(origen);
            Vertex<String> vDestino = sitios.search(destino);

            if (vOrigen != null && vDestino != null) {

                boolean[] evitar = new boolean[sitios.getSize()];
                for (String sitio : evitarPasarPor) {
                    Vertex<String> vSitio = sitios.search(sitio);
                    if (vSitio != null) {
                        evitar[vSitio.getPosition()] = true;
                    }
                }

                boolean[] marca = new boolean[sitios.getSize()];
                List<String> caminoActual = new LinkedList<>();
                recorrido(sitios, vOrigen, destino, evitar, marca, 0, caminoActual, caminos);

            }
        }
        return caminos;
    }

    private void recorrido (Graph<String>sitios,Vertex<String>vActual,
                            String destino, boolean[] evitar, boolean[] marca, int distancia,
                            List<String>caminoActual, List<CaminoConDistancia> caminos){

        int i = vActual.getPosition();
        marca[i]=true;
        caminoActual.add(vActual.getData());

        if (vActual.getData().equals(destino)){
            CaminoConDistancia caminoConDistancia = new CaminoConDistancia();
            caminoConDistancia.setCamino(caminoActual);
            caminoConDistancia.setDistancia(distancia);
            caminos.add(caminoConDistancia);
        }
        else {
            for (Edge<String> edge: sitios.getEdges(vActual)){
                Vertex<String>target = edge.getTarget();
                int peso = edge.getWeight();
                int j = target.getPosition();

                if (!marca[j] && !evitar[j]){
                    recorrido(sitios,target,destino,evitar,marca,distancia+peso,caminoActual,caminos);
                }
            }
        }
        marca[i]=false;
        caminoActual.removeLast();

}







}
