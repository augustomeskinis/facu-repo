package grafos.parcial4_desaprobado_18_11_2025;

import clases.Edge;
import clases.Graph;
import clases.Vertex;

import java.util.LinkedList;
import java.util.List;

public class Parcial {

    public List<Par> distanciasMinimas(Graph<String> grafo) {
        List<Par> lista = new LinkedList<>();
        if (grafo != null && !grafo.isEmpty()) {
            for (int i = 0; i < grafo.getSize(); i++) {
                boolean[] marca = new boolean[grafo.getSize()];
                Vertex<String> origen = grafo.getVertex(i);
                String or = origen.getData();
                dfs(grafo, i, lista, marca, origen, null, or, 0);
            }
        }
        return lista;
    }


    public void dfs(Graph<String> grafo, int i, List<Par> lista, boolean[] marca,
                    Vertex<String> vOrigen, Vertex<String> vDestino, String origen, int distancia) {

        marca[i] = true;
        boolean encontre = false;
        if (vDestino != null) {
            String destino = vDestino.getData();
            for (Par par : lista) {
                if ( par.getOrigen().equals(origen) && par.getDestino().equals(destino)){
                    if (distancia < par.getDistancia()){
                        par.setDistancia(distancia);
                        encontre=true;
                    }
                }
            }
            if (!encontre){
                Par par = new Par (origen,destino,distancia);
                lista.add(par);
            }
        }
        for(Edge<String> edge: grafo.getEdges(vOrigen)){
            vDestino= edge.getTarget();
            int j= vDestino.getPosition();
            int distanciaNueva=edge.getWeight()+distancia;
            if (!marca[j]){
                dfs(grafo,j,lista,marca,vOrigen,vDestino,origen,distanciaNueva);
            }
        }
        marca[i]=false;
    }
}
