import ejercicio1.Edge;
import ejercicio1.Graph;
import ejercicio1.Vertex;

import java.util.List;

public class Parcial {

    public Tupla nivelPopularidad(Graph<String> red, String usuario, int distancia, int umbral){
        Vertex<String>origen = red.search(usuario);
        Tupla t = null;
        if (origen!= null){
            t = new Tupla(0,false);
            boolean [] marca = new boolean[red.getSize()];
            bfs(origen.getPosition(),red,distancia,umbral,marca,t);
        }
        return t;
    }

    private void bfs(int i, Graph<String> red, int distancia, int umbral, boolean[] marca, Tupla t){
        Queue<Vertex<String>> q =new Queue<>();
        q.enqueue(red.getVertex(i));
        q.enqueue(null);
        marca[i]=true;
        int nivel=0; int cantAmigos;
        while (!q.isEmpty() && (nivel < distancia)){
            Vertex<String> w =q.dequeue();
            if (w != null) {
                List<Edge<String>> adyacentes = red.getEdges(w);
                for (Edge<String> e : adyacentes) {
                    int j = e.getTarget().getPosition();
                    if (!marca[j]) {
                        marca[j] = true;
                        q.enqueue(e.getTarget());
                    }
                }
            }
            else {
                nivel++;
                if (nivel == distancia) {
                    int cantUsuarios= q.size();
                    t.setCantUsuarios(cantUsuarios);
                    if (cantUsuarios>=umbral){
                        t.setEsPopular(true);
                    }
                }
                q.enqueue(null);
            }
        }
    }
}
