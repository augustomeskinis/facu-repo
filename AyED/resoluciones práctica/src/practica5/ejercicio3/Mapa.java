package practica5.ejercicio3;

import practica5.ejercicio1.Edge;
import practica5.ejercicio1.Graph;
import practica5.ejercicio1.Vertex;
import practica5.ejercicio1.adjList.AdjListGraph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Mapa {
    private Graph<String> mapaCiudades;

    public Mapa (Graph<String> mapa){
        this.mapaCiudades = mapa;
    }

    public List<String> devolverCamino (String ciudad1, String ciudad2){
        Vertex<String> origen = this.mapaCiudades.search(ciudad1);
        Vertex<String> destino = this.mapaCiudades.search(ciudad2);
        if ((origen != null) && (destino != null)){
            boolean[] marca = new boolean[mapaCiudades.getSize()];
            List<String> camino = new ArrayList<>();
            return dfs1(origen.getPosition(),destino.getData(),marca,camino);
        }
        System.out.println("no se encontro el origen o el destino en el grafo");
        return new ArrayList<>();
    }

    private List<String> dfs1(int i, String destino, boolean[] marca, List<String> camino){
        marca[i] = true;
        Vertex<String> actual = mapaCiudades.getVertex(i);
        camino.add(actual.getData());

        if (actual.getData().equals(destino)){
            return new ArrayList<>(camino);
        }

        for (Edge<String> e: mapaCiudades.getEdges(actual)){
            int j = e.getTarget().getPosition();
            if(!marca[j]){
                List<String> resultado = dfs1(j,destino,marca,camino);
                if (!resultado.isEmpty()){
                    return resultado;
                }
            }
        }
        camino.remove(camino.size()-1);
        return new ArrayList<>();
    }

    public List<String>devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades){
        Vertex<String> origen = this.mapaCiudades.search(ciudad1);
        Vertex<String> destino = this.mapaCiudades.search(ciudad2);
        if ((origen != null) && (destino != null)){
            boolean[] marca = new boolean[mapaCiudades.getSize()];
            List<String> camino = new ArrayList<>();
            return dfs2(origen.getPosition(),destino.getData(),marca,camino,ciudades);
        }
        System.out.println("no se encontro el origen o el destino en el grafo");
        return new ArrayList<>();
    }

    private boolean estaEnLaLista(String ciudad, List<String> ciudades){
        for(String ciudadActual: ciudades){
            if (ciudadActual.equals(ciudad)){
                return true;
            }
        }
        return false;
    }


    private List<String> dfs2 (int i, String destino, boolean[] marca, List<String> camino, List<String> ciudades){
        marca[i] = true;
        Vertex<String> actual = mapaCiudades.getVertex(i);
        camino.add(actual.getData());

        if (actual.getData().equals(destino)){
            return new ArrayList<>(camino);
        }

        for (Edge<String> e: mapaCiudades.getEdges(actual)){
            int j = e.getTarget().getPosition();
            boolean esta = estaEnLaLista(e.getTarget().getData(),ciudades);
            if (esta){
                marca[j] = true;
            }
            else{
                List<String> resultado = dfs2(j,destino,marca,camino,ciudades);
                if (!resultado.isEmpty()){
                    return resultado;
                }
            }
        }

        camino.remove(camino.size()-1);
        return new ArrayList<>();
    }

    public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
        List<String> camino = new LinkedList<String>();
        if((this.mapaCiudades != null)&&(!this.mapaCiudades.isEmpty())) {
            Vertex origen = this.mapaCiudades.search(ciudad1);
            Vertex destino = this.mapaCiudades.search(ciudad2);
            if(origen != null && destino != null) {
                dfs3(origen, destino, camino, new LinkedList<String>(), new boolean[mapaCiudades.getSize()], 0, Integer.MAX_VALUE);
            }
        }
        return camino;
    }

    private int dfs3(Vertex<String> origen, Vertex<String> destino, List<String> caminoMinimo, List<String> caminoAct, boolean[] marcas, int total, int min) {
        marcas[origen.getPosition()] = true;
        caminoAct.add(origen.getData());
        if(origen == destino && total < min) {
            caminoMinimo.removeAll(caminoMinimo);
            caminoMinimo.addAll(caminoAct);
            min = total;
        } else {
            List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext() && total < min) {
                Edge<String> v = it.next();
                int j = v.getTarget().getPosition();
                int aux = total + v.getWeight();
                if(!marcas[j] && aux < min) {
                    min = dfs3(v.getTarget(), destino, caminoMinimo, caminoAct, marcas, aux, min);
                }
            }
        }
        marcas[origen.getPosition()] = false;
        caminoAct.remove(caminoAct.size()-1);
        return min;
    }

    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        List<String> camino = new LinkedList<String>();
        if(!this.mapaCiudades.isEmpty()) {
            Vertex origen = this.mapaCiudades.search(ciudad1);
            Vertex destino = this.mapaCiudades.search(ciudad2);
            if(origen != null && destino != null) {
                dfs4(origen, destino, camino, new boolean[this.mapaCiudades.getSize()], tanqueAuto);
            }
        }
        return camino;
    }

    private boolean dfs4(Vertex<String> origen, Vertex<String> destino, List<String> camino, boolean[] marcas, int tanqueAuto) {
        boolean encontre = false;
        marcas[origen.getPosition()] = true;
        camino.add(origen.getData());
        if(origen == destino) {
            return true;
        } else {
            List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext() && !encontre) {
                Edge<String> v = it.next();
                int j = v.getTarget().getPosition();
                if(!marcas[j] && tanqueAuto - v.getWeight() > 0) {
                    encontre = dfs4(v.getTarget(), destino, camino, marcas, tanqueAuto - v.getWeight());
                }
            }
        }
        if(!encontre) {
            camino.remove(camino.size()-1);
        }
        marcas[origen.getPosition()] = false;
        return encontre;
    }


    public List<String> caminoConMenorCargaCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        List<String> camino = new LinkedList<String>();
        if(!this.mapaCiudades.isEmpty()) {
            Vertex origen = this.mapaCiudades.search(ciudad1);
            Vertex destino = this.mapaCiudades.search(ciudad2);
            if(origen != null && destino != null) {
                dfs5(origen, destino, camino, new LinkedList<String>(), new boolean[mapaCiudades.getSize()], tanqueAuto, tanqueAuto, 0, Integer.MAX_VALUE);
            }
        }
        return camino;
    }

    private int dfs5(Vertex<String> origen, Vertex<String> destino, List<String> caminoMinimo, List<String> caminoAct, boolean[] marcas, int tanqueActual, int tanque, int recargas, int recargasMin) {
        marcas[origen.getPosition()] = true;
        caminoAct.add(origen.getData());
        if(origen == destino && recargas < recargasMin) {
            caminoMinimo.removeAll(caminoMinimo);
            caminoMinimo.addAll(caminoAct);
            recargasMin = recargas;
        } else {
            List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext() && recargas < recargasMin) {
                Edge<String> v = it.next();
                int j = v.getTarget().getPosition();
                int distancia = v.getWeight();
                if(!marcas[j]) {
                    if(tanqueActual >= distancia) {
                        recargasMin = dfs5(v.getTarget(), destino, caminoMinimo, caminoAct, marcas, tanqueActual - distancia, tanque, recargas, recargasMin);
                    } else if (tanque >= distancia) {
                        recargasMin = dfs5(v.getTarget(), destino, caminoMinimo, caminoAct, marcas, tanque - distancia, tanque, recargas+1, recargasMin);
                    }
                }
            }
        }
        marcas[origen.getPosition()] = false;
        caminoAct.remove(caminoAct.size()-1);
        return recargasMin;
    }

    public static void main (String [] args){
        // probando el metodo1 "devolverCamino"

        Graph<String> ciudadPrueba = new AdjListGraph<>();
        Vertex<String> BA = ciudadPrueba.createVertex("Buenos Aires");
        Vertex<String> LP = ciudadPrueba.createVertex("La Plata");
        Vertex<String> TL = ciudadPrueba.createVertex("Tolosa"); // agrego un vértice más pero no lo conecto, para probar
        ciudadPrueba.connect(BA,LP);
        Vertex<String> AV = ciudadPrueba.createVertex("Avellaneda");
        ciudadPrueba.connect(LP,AV);

        Mapa mapaPrueba = new Mapa(ciudadPrueba);
        List<String> listaPrueba = mapaPrueba.devolverCamino("Buenos Aires", "Avellaneda");
        System.out.println("probando el método 'devolverCamino'");
        for(String ciudad: listaPrueba){
            System.out.println(ciudad);
        }

        // probando el metodo2 "devolverCaminoExceptuando"

        List<String> ciudades = new ArrayList<>();
        ciudades.add("La Plata");
        listaPrueba = mapaPrueba.devolverCaminoExceptuando("Buenos Aires","Avellaneda",ciudades);
        System.out.println("probando el método 'devolverCaminoExceptuando'"); //
        for(String ciudad: listaPrueba){
            System.out.println(ciudad);
        }

        // probando el método3 "devolverCaminoExceptuando"

        Vertex<String> MIN = ciudadPrueba.createVertex("Minnesota");
        Vertex<String> DEN = ciudadPrueba.createVertex("Denver");
        ciudadPrueba.connect(MIN, DEN, 10);
        Vertex<String> LA = ciudadPrueba.createVertex("Los Angeles");
        ciudadPrueba.connect(DEN,LA,1);
        Vertex<String> SEA = ciudadPrueba.createVertex("Seattle");
        ciudadPrueba.connect(DEN,SEA,4);
        Vertex<String> SF = ciudadPrueba.createVertex("San Francisco");
        ciudadPrueba.connect(LA,SF, 1);
        ciudadPrueba.connect(SEA,SF, 3);
                // camino de minnesota a San Francisco por seattle = 15km
                // camino de minesota a San Francisco por Los Angeles = 12km
                // por lo tanto, el metodo deberia imprimir Minnesota-Denver-LosAngeles-San Francisco, distancias 12km
        listaPrueba = mapaPrueba.caminoMasCorto("Minnesota","San Francisco");
        for(String ciudad: listaPrueba){
            System.out.println(ciudad);
        }
    }
}