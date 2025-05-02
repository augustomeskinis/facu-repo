package practica3.ejercicio11;

import practica1.ejercicio8.Queue;
import practica3.ejercicio5.GeneralTree;

public class Ejercicio11 {

    public static boolean resolver(GeneralTree<Integer> tree){
        Queue<GeneralTree<Integer>>queue = new Queue<>();
        GeneralTree<Integer>treeAux;
        boolean esCreciente = true;
        int cantNodosNivelActual = 0;
        int cantNodosNivelSiguiente = 0;

        queue.enqueue(tree);
        queue.enqueue(null);
        while (!queue.isEmpty() && esCreciente){
            treeAux = queue.dequeue();
            if (treeAux != null) {
                cantNodosNivelActual++;
                for (GeneralTree<Integer> child : treeAux.getChildren()) {
                    cantNodosNivelSiguiente++;
                    queue.enqueue(child);
                }
            }
            else {
                if (!queue.isEmpty()) {
                    if (cantNodosNivelActual + 1 == cantNodosNivelSiguiente ) {
                        cantNodosNivelActual = 0;
                        cantNodosNivelSiguiente = 0;
                        queue.enqueue(null);
                    }
                    else {
                        esCreciente=false;
                    }
                }
            }
        }
        return esCreciente;
    }
    public static void main(String[] args) {
        GeneralTree<Integer>arbol = new GeneralTree<>(1);
        GeneralTree<Integer>nodo1 = new GeneralTree<>(2);
        GeneralTree<Integer>nodo2 = new GeneralTree<>(3);

        arbol.addChild(nodo1);
        arbol.addChild(nodo2);

        System.out.println("es creciente? = " + resolver(arbol));
    }
}
