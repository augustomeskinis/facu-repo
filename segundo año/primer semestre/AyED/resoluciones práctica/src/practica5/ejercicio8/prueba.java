package practica5.ejercicio8;

import practica5.ejercicio1.adjList.AdjListGraph;
import practica5.ejercicio1.Graph;
import practica5.ejercicio1.Vertex;
import practica5.ejercicio8.Ejercicio8;

public class prueba {
    public static void main(String[] args) {
        // Crear el grafo
        Graph<String> grafo = new AdjListGraph<>();

        // Crear las neuronas (vértices)
        Vertex<String> n1 = grafo.createVertex("N1");
        Vertex<String> n2 = grafo.createVertex("N2");
        Vertex<String> n3 = grafo.createVertex("N3");
        Vertex<String> n4 = grafo.createVertex("N4");
        Vertex<String> n5 = grafo.createVertex("N5");
        Vertex<String> n6 = grafo.createVertex("N6");
        Vertex<String> n7 = grafo.createVertex("N7");
        Vertex<String> n8 = grafo.createVertex("N8");
        Vertex<String> n9 = grafo.createVertex("N9");
        // Conectar las neuronas según el diagrama
        // N1 envía impulso 100
        grafo.connect(n1, n2, 200);  // N1 -> N2 (peso 200)
        grafo.connect(n1, n3, 80);   // N1 -> N3 (peso 80) - BLOQUEADO por X
        grafo.connect(n1, n7, 100);  // N1 -> N7 (peso 100)

        // N2 propaga
        grafo.connect(n3, n2, 20);   // N2 -> N4 (peso 20)

        // N3 propaga
        grafo.connect(n3, n4, 1000); // N3 -> N4 (peso 1000)
        grafo.connect(n3, n5, 5);    // N3 -> N5 (peso 5)
        grafo.connect(n3, n7, 100);  // N3 -> N7 (peso 100)

        // N7 propaga
        grafo.connect(n7, n9, 10);   // N7 -> N6 (peso 10) - BLOQUEADO por X
        grafo.connect(n7, n8, 90);   // N7 -> N8 (peso 90)

        // N8 propaga
        // Ejecutar el algoritmo
        Ejercicio8 ej8 = new Ejercicio8();
        int resultado = ej8.neuronasActivadas(grafo, "N1", 100);

        System.out.println("Neuronas activadas: " + resultado);
    }
}