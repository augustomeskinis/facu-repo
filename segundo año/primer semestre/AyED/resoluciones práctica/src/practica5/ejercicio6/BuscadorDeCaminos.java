package practica5.ejercicio6;

import practica5.ejercicio1.Edge;
import practica5.ejercicio1.Graph;
import practica5.ejercicio1.Vertex;
import practica5.ejercicio1.adjList.AdjListGraph;

import java.util.ArrayList;
import java.util.List;

public class BuscadorDeCaminos {
    private Graph<String> bosque;

    public BuscadorDeCaminos(Graph<String> grafo) {
        this.bosque = grafo;
    }

    public List <List<String>> recorridosMasSeguros(){
        Vertex<String> casaCaperucita = bosque.search("Casa Caperucita");
        Vertex<String> casaAbuela = bosque.search("Casa Abuelita");
        List<List<String>> recorridos = new ArrayList<>();
        if ((bosque != null) && (!bosque.isEmpty()) && (casaCaperucita != null) && (casaAbuela!= null)){
                List<String> recorridoActual = new ArrayList<>();
                boolean[] marca = new boolean[bosque.getSize()];
                buscarRecorridos(casaCaperucita.getPosition(),casaAbuela.getData(),marca,recorridoActual,recorridos);
            }
        return recorridos;
    }

    private void buscarRecorridos(int i, String destino, boolean[] marca, List<String> recorridoActual, List<List<String>> recorridos){
        marca[i] = true;
        Vertex<String>actual = bosque.getVertex(i);
        recorridoActual.add(actual.getData());

        if (destino.equals(actual.getData())){
            recorridos.add(new ArrayList<>(recorridoActual));
        }

        for (Edge<String> e: bosque.getEdges(actual)){
            int j = e.getTarget().getPosition();
            if (!marca[j]){
                int frutales = e.getWeight();
                if (frutales <= 5){
                    buscarRecorridos(j,destino,marca,recorridoActual,recorridos);
                }
            }
        }
        recorridoActual.remove(recorridoActual.size()-1);
        marca[i]=false;
    }

    public static void main(String[]args){
        Graph<String> grafo = new AdjListGraph<>();
        Vertex<String> casaCaperucita = grafo.createVertex("Casa Caperucita");
        Vertex<String> claro1= grafo.createVertex("Claro1");
        Vertex<String> claro2=grafo.createVertex("Claro2");
        Vertex<String> claro3=grafo.createVertex("Claro3");
        Vertex<String> claro4=grafo.createVertex("Claro4");
        Vertex<String> claro5=grafo.createVertex("Claro5");
        Vertex<String>casaAbuelita=grafo.createVertex("Casa Abuelita");
        grafo.connect(casaCaperucita,claro2,4);
        grafo.connect(casaCaperucita,claro1,3);
        grafo.connect(casaCaperucita,claro3,4);
        grafo.connect(claro2,claro1,4);
        grafo.connect(claro2,claro4,10);
        grafo.connect(claro2,claro5,11);
        grafo.connect(claro1,claro5,3);
        grafo.connect(claro3,claro5,15);
        grafo.connect(claro4,casaAbuelita,9);
        grafo.connect(claro5,casaAbuelita,4);
        BuscadorDeCaminos buscador = new BuscadorDeCaminos(grafo);
        List<List<String>> recorridos = buscador.recorridosMasSeguros();
        int i = 0;
        for (List<String> lista: recorridos){
            i++;
            System.out.println("recorrido " + i);
            for (String casa: lista){
                System.out.println(casa);
            }
        }
    }
}
