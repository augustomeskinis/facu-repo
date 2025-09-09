package parcial1.enunciado;

import clases.GeneralTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import clases.Queue;

public class Parcial1 {
    public List<Integer> nivel (GeneralTree<Integer> arbol, int num){
        List<Integer> nodos = new LinkedList<>();
        if ((arbol!= null)&&(!arbol.isEmpty())){
            porNiveles(arbol,nodos,num);
        }
        return nodos;
    }

    private void porNiveles(GeneralTree<Integer> tree, List<Integer> nodos, int num) {
        Queue<GeneralTree<Integer>> queue = new Queue<>();
        queue.enqueue(tree);

        boolean encontrado = false;

        while (!queue.isEmpty() && !encontrado) {
            int size = queue.size();
            boolean cumple = true;

            for (int i = 0; i < size; i++) {
                GeneralTree<Integer> nodo = queue.dequeue();
                nodos.add(nodo.getData());

                if (nodo.getChildren().size() < num) {
                    cumple = false;
                }

                // Cargamos hijos para el siguiente nivel
                for (GeneralTree<Integer> hijo : nodo.getChildren()) {
                    queue.enqueue(hijo);
                }
            }

            if (!cumple) {
                nodos.clear(); // si no se cumplió la condición, vaciamos
            } else {
                encontrado = true; // si se cumplió, terminamos
            }
        }
    }
}
