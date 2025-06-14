package practica5.ejercicio5;

import practica5.ejercicio1.Edge;
import practica5.ejercicio1.Graph;
import practica5.ejercicio1.Vertex;
import practica1.ejercicio8.Queue;
import practica5.ejercicio1.adjList.AdjListGraph;

import java.util.ArrayList;
import java.util.List;

public class BancoItaú {

    public List<Persona> quedateEnCasa (Graph<Persona> grafo, Empleado empleado, int distancia){
        if ((grafo != null) && (!grafo.isEmpty())){
            Vertex<Persona> vEmpleado = grafo.search(empleado);
            if (vEmpleado != null){
                List<Persona> jubilados = new ArrayList<>();
                bfs(grafo,vEmpleado,jubilados,distancia);
                return jubilados;
            }
        }
        return new ArrayList<>();
    }
    public void bfs (Graph<Persona> grafo, Vertex<Persona> empleado,List<Persona> jubilados, int gradoSeparacion){
        Queue<Vertex<Persona>> q = new Queue<>();
        boolean [] visitados = new boolean[grafo.getSize()];

        visitados[empleado.getPosition()]=true;
        q.enqueue(empleado);
        int nivel = 0; int cantPersonas = 0;
        while (!q.isEmpty() && (nivel <gradoSeparacion) && jubilados.size() < 40) {
            cantPersonas = q.size();

            for (int i = 0; (i < cantPersonas) && (jubilados.size() < 40) ; i++){
                Vertex<Persona> verticeActual = q.dequeue();

                for (Edge<Persona> e: grafo.getEdges(verticeActual)){
                    Vertex<Persona> verticeDestino = e.getTarget();
                    if (!visitados[verticeDestino.getPosition()]){
                        visitados[verticeDestino.getPosition()] = true;
                        q.enqueue(verticeDestino);

                        if (verticeDestino.getData().esJubilado() ){
                            Jubilado j = (Jubilado) verticeDestino.getData();
                            if (!j.yaCobro()){
                                jubilados.add(j);
                            }

                        }
                    }
                }
            }
            nivel++;
        }
    }

    public static void main(String[] args) {
        // Crear el grafo usando tu implementación
        Graph<Persona> grafo = new AdjListGraph<>();

        // Crear personas
        Empleado ana = new Empleado("Ana", "Calle 123");
        Jubilado carlos = new Jubilado("Carlos", "Calle A", false); // no cobró
        Jubilado maria = new Jubilado("María", "Calle B", true);    // ya cobró
        Jubilado pedro = new Jubilado("Pedro", "Calle C", false);   // no cobró
        Empleado luis = new Empleado("Luis", "Calle 456");
        Jubilado laura = new Jubilado("Laura", "Calle D", false);   // no cobró
        Jubilado marta = new Jubilado("Marta", "Calle E", false);   // no cobró

        // Agregar vértices al grafo
        Vertex<Persona> vAna = grafo.createVertex(ana);
        Vertex<Persona> vCarlos = grafo.createVertex(carlos);
        Vertex<Persona> vMaria = grafo.createVertex(maria);
        Vertex<Persona> vPedro = grafo.createVertex(pedro);
        Vertex<Persona> vLuis = grafo.createVertex(luis);
        Vertex<Persona> vLaura = grafo.createVertex(laura);
        Vertex<Persona> vMarta = grafo.createVertex(marta);

        // Conectar vértices (grafo no dirigido)
        grafo.connect(vAna, vCarlos);   // distancia 1
        grafo.connect(vCarlos, vMaria); // distancia 2
        grafo.connect(vMaria, vPedro);  // distancia 3
        grafo.connect(vAna, vLuis);     // distancia 1
        grafo.connect(vLuis, vLaura);   // distancia 2
        grafo.connect(vLuis, vMarta);   // distancia 2

        // Crear instancia de BancoItaú
        BancoItaú banco = new BancoItaú();

        // Ejecutar método
        int distanciaMax = 2;
        List<Persona> jubilados = banco.quedateEnCasa(grafo, ana, distanciaMax);

        // Mostrar resultados
        System.out.println("Jubilados que deben quedarse en casa:");
        for (Persona p : jubilados) {
            System.out.println("- " + p.getNombre() + " en " + p.getDomicilio());
        }
    }
}
