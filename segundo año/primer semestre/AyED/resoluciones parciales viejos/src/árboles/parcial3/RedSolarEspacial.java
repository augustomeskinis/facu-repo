package árboles.parcial3;
import clases.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class RedSolarEspacial {
    GeneralTree<Derivador> arbol;


    public GeneralTree<Derivador> buscarNodo (GeneralTree<Derivador> nodoActual, String panelInicial){
        String nombreActual = nodoActual.getData().getNombre();

        if (nombreActual.equals(panelInicial)){
            return nodoActual;
        }

        for (GeneralTree<Derivador> hijo: nodoActual.getChildren()){
            GeneralTree<Derivador> nodo = buscarNodo(hijo,panelInicial);
            if (nodo != null){
                return nodo;
            }
        }
        return null;
    }


    // ERROR 2 CORREGIDO: Pasar energiaTotal al método recorrido
    public double minimoSuministroEnergia(double energiaTotal, String panelInicial) {
        if ((arbol != null) && (!arbol.isEmpty())) {
            GeneralTree<Derivador> nodo = this.buscarNodo(arbol, panelInicial);
            if (nodo != null) {
                return recorrido(energiaTotal, nodo);
            }
        }
        return -1;
    }

    // ERROR 3 CORREGIDO: Dividir la energía ANTES de la recursión
    public double recorrido(double energia, GeneralTree<Derivador> nodo) {
        // Si el nodo no está activo, descartar este camino
        if (!nodo.getData().isActivo()) {
            return -1;
        }

        // Caso base: si es hoja y activo, retorna la energía recibida
        if (nodo.isLeaf()) {
            return energia;
        }

        List<Double> resultadosHijosActivos = new LinkedList<>();

        // Contar hijos activos primero
        int hijosActivos = 0;
        for (GeneralTree<Derivador> hijo : nodo.getChildren()) {
            if (hijo.getData().isActivo()) {
                hijosActivos++;
            }
        }

        // Si no hay hijos activos, retornar -1
        if (hijosActivos == 0) {
            return -1;
        }

        // Dividir la energía entre los hijos activos
        double energiaPorHijo = energia / hijosActivos;

        // Recorrer los hijos activos con la energía dividida
        for (GeneralTree<Derivador> hijo : nodo.getChildren()) {
            if (hijo.getData().isActivo()) {
                double resultado = recorrido(energiaPorHijo, hijo);
                if (resultado != -1) {
                    resultadosHijosActivos.add(resultado);
                }
            }
        }

        // Si ningún hijo activo tiene camino válido, retornar -1
        if (resultadosHijosActivos.isEmpty()) {
            return -1;
        }

        // Retornar el mínimo de los resultados
        double min = Double.MAX_VALUE;
        for (double r : resultadosHijosActivos) {
            if (r < min) {
                min = r;
            }
        }
        return min;
    }
}
