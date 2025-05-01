package practica3.ejercicio10;

import practica3.ejercicio5.GeneralTree;

import java.util.LinkedList;
import java.util.List;
import practica1.ejercicio8.Queue;

public class Ejercicio10 {
    /*
        EXPLICACIÓN
            METODO RESOLVER
                1. crea las listas caminoActual y caminoFiltradoDevalorMaximo
                2. checkea que el arbol no sea null ni esté vacio.
                3. llama a buscarCamino, que le devuelve el caminoFiltradoDeValorMaximo
                4. retorna el caminoFiltradoDeValorMaximo.
            METODO BUSCAR CAMINO
                1. realiza un recorrido en profundidad.
                2. agrega solo los nodos con valor 1.
                3. si el nodo actual es hoja
                    - recorre las dos listas enteras (caminoActual y caminoDeValorMaximo)
                    para calcular si el caminoActual es mayor que el camino de valor máximo.
                    - si es mayor, actualiza el camino de valor máximo.
                4. si no es hoja, llama al méetodo con los hijos.
                5. para el backtracking, elimina el nodo actual.
        PREGUNTAS
            - el méetodo buscarCamino claramente no es eficiente, ya que cada vez que llega a una hoja recorre las dos listas
            enteras. se puede hacer con parámetros eso? porque como no son por referencia, no se pueden actualizar.
            - es necesaria una variable "nivel"?, porque en la solucion no la usé.
     */

    public static List<Integer> resolver (GeneralTree<Integer> arbol){
        List<Integer> caminoActual = new LinkedList<>();
        List<Integer> caminoFiltradoDeValorMaximo = new LinkedList<>();
        if ((arbol != null) && (!arbol.isEmpty())){
            buscarCamino(arbol,caminoActual,caminoFiltradoDeValorMaximo);
        }
        return caminoFiltradoDeValorMaximo;
    }

    private static void buscarCamino(GeneralTree<Integer> nodo,
                                     List<Integer> caminoActual, List<Integer> caminoValorMaximo ){

        if (nodo.getData().equals(1)){
            caminoActual.add(1);
        }

        if (nodo.isLeaf()){
            int valorCaminoActual = 0;
            int valorCaminoMaximo = 0;
            for(int i = 0; i < caminoActual.size(); i++){
                valorCaminoActual += i * caminoActual.get(i);
            }
            for(int i = 0; i < caminoValorMaximo.size(); i++){
                valorCaminoMaximo += i * caminoValorMaximo.get(i);
            }
            if (valorCaminoActual > valorCaminoMaximo){
                caminoValorMaximo.clear();
                caminoValorMaximo.addAll(caminoActual);

            }
        }
        else {
            for (GeneralTree<Integer>child: nodo.getChildren()){
                buscarCamino(child,caminoActual,caminoValorMaximo);
            }
        }
        if (nodo.getData().equals(1)) {
            caminoActual.remove(caminoActual.size() - 1);}
    }

    public static void main (String [] args){

        // armo el árbol de ejemplo de la práctica

        GeneralTree <Integer> raiz = new GeneralTree<>(1);

        GeneralTree <Integer> nodo1 = new GeneralTree<>(0);
        GeneralTree <Integer> nodo2 = new GeneralTree<>(1);
        GeneralTree <Integer> nodo3 = new GeneralTree<>(1);
        raiz.addChild(nodo1);
        raiz.addChild(nodo2);
        raiz.addChild(nodo3);

        GeneralTree <Integer> nodo4 = new GeneralTree<>(1);
        GeneralTree <Integer> nodo5 = new GeneralTree<>(1);
        nodo1.addChild(nodo4);
        nodo1.addChild(nodo5);

        GeneralTree <Integer> nodo6 = new GeneralTree<>(1);
        GeneralTree <Integer> nodo7 = new GeneralTree<>(0);
        nodo2.addChild(nodo6);
        nodo2.addChild(nodo7);

        GeneralTree<Integer>nodo8 = new GeneralTree<>(0);
        nodo3.addChild(nodo8);

        GeneralTree <Integer> nodo9 = new GeneralTree<>(1);
        GeneralTree <Integer> nodo10 = new GeneralTree<>(1);
        GeneralTree <Integer> nodo11= new GeneralTree<>(1);
        nodo4.addChild(nodo9);
        nodo4.addChild(nodo10);
        nodo4.addChild(nodo11);


        GeneralTree<Integer>nodo12 = new GeneralTree<>(0);
        nodo7.addChild(nodo12);

        GeneralTree<Integer>nodo13 = new GeneralTree<>(0);
        nodo8.addChild(nodo12);

        GeneralTree<Integer>nodo14 = new GeneralTree<>(0);
        nodo12.addChild(nodo14);

        GeneralTree<Integer>nodo15 = new GeneralTree<>(0);
        GeneralTree<Integer>nodo16 = new GeneralTree<>(0);
        nodo13.addChild(nodo15);
        nodo13.addChild(nodo15);

        List<Integer> caminoFiltradoDeValorMaximo = resolver(raiz);
        for (int valor : caminoFiltradoDeValorMaximo) {
            System.out.println(valor);
        }
    }


}