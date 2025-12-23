package árboles.parcial6;

import clases.GeneralTree;
import clases.Queue;

public class ParcialArboles {

    public static boolean resolver (GeneralTree<Integer> arbol){
        if(arbol!=null && !arbol.isEmpty()){
            return recorridoPorNiveles(arbol);
        }
        return false;
    }

    public static boolean recorridoPorNiveles(GeneralTree<Integer> arbol){
        Queue<GeneralTree<Integer>> queue = new Queue<>();

        boolean esCreciente = true;
        int nodosNivelActual = 1;  // El árbol comienza con 1 nodo (la raíz)

        queue.enqueue(arbol);

        while (!queue.isEmpty() && esCreciente){
            int size = queue.size();
            int nodosNivelSiguiente = 0;

            // Procesa todos los nodos del nivel actual
            for(int i = 0; i < size; i++){
                GeneralTree<Integer> nodoActual = queue.dequeue();

                // Cuenta los hijos (nodos del siguiente nivel)
                for(GeneralTree<Integer> child : nodoActual.getChildren()){
                    nodosNivelSiguiente++;
                    queue.enqueue(child);
                }
            }

            // Verifica que el siguiente nivel tenga exactamente un nodo más
            if(nodosNivelSiguiente > 0 && nodosNivelSiguiente != nodosNivelActual + 1){
                esCreciente = false;
            }
            nodosNivelActual = nodosNivelSiguiente;
        }

        return esCreciente;
    }


}
