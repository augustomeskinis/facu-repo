package practica5.ejercicio2;
import practica5.ejercicio1.Graph;
import practica5.ejercicio1.Vertex;
import practica5.ejercicio1.Edge;

import java.util.List;


public class Recorridos <T> {
    public void dfs(Graph<T> grafo) {
        boolean[] marca = new boolean[grafo.getSize()];
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!marca[i]) {
                System.out.println("largo con: "+grafo.getVertex(i).getData());
                dfs(i, grafo, marca);
            }
        }
    }

    private void dfs(int i, Graph<T> grafo, boolean[] marca) {
        marca[i] = true;
        Vertex<T> v = grafo.getVertex(i);
        System.out.println(v);
        List<Edge<T>> adyacentes = grafo.getEdges(v); //adyacentes
        for (Edge<T> e: adyacentes){
            int j = e.getTarget().getPosition();
            if (!marca[j]) {
                dfs(j, grafo, marca);
            }
        }
    }
}
