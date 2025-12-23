package practica5.ejercicio8;

import practica1.ejercicio8.Queue;
import practica5.ejercicio1.Edge;
import practica5.ejercicio1.Graph;
import practica5.ejercicio1.Vertex;
import java.util.List;

public class Ejercicio8 {

    public int neuronasActivadas (Graph<String> grafo, String inicio, int impulso) {
        int neuronasActivadas = 0;

        if (grafo != null && !grafo.isEmpty()) {
            Vertex<String> v = grafo.search(inicio);
            boolean[] marca = new boolean[grafo.getSize()];
            neuronasActivadas = bfs(v.getPosition(), grafo,marca, impulso);
        }
        return neuronasActivadas;
    }

    private int bfs(int pos, Graph<String> grafo, boolean[] marca, int impulso) {
        Queue<Vertex<String>> q = new Queue<>();
        q.enqueue(grafo.getVertex(pos));
        marca[pos] = true;
        int cantNeuronas = 1;

        while (!q.isEmpty()) {
            int size = q.size(); // Tamaño del nivel actual
            int impulsoReducido = (int)(impulso * 0.9); // Reducir 10%

            for (int i = 0; i < size; i++) { // Procesar todo el nivel
                Vertex<String> vActual = q.dequeue();
                List<Edge<String>> adyacentes = grafo.getEdges(vActual);

                for (Edge<String> e : adyacentes) {
                    int j = e.getTarget().getPosition();

                    // El impulso debe superar o igualar la fuerza sináptica
                    if (!marca[j] && impulsoReducido <= e.getWeight()) {
                        marca[j] = true;
                        q.enqueue(e.getTarget()); // Encolar el destino, no vActual
                        cantNeuronas++;
                    }
                }
            }
            impulso = impulsoReducido; // Actualizar impulso para el siguiente nivel
        }
        return cantNeuronas;
    }

}