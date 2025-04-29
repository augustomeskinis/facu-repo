package practica3.ejercicio10;

import practica3.ejercicio5.GeneralTree;

import java.util.LinkedList;
import java.util.List;
import practica1.ejercicio8.Queue;

public class Ejercicio10 {
    /*
        PASOS:
     */

    public static List<Integer> resolver (GeneralTree<Integer> arbol){
        List<Integer> listaMax;
        GeneralTree<Integer> arbolAux;

        Queue<GeneralTree<Integer>> queue = new Queue<>() ;
        queue.enqueue(arbol);
        while(!queue.isEmpty()){
            arbolAux = queue.dequeue();
            List<Integer> listaActual = new LinkedList<>();
            listaActual.add(arbolAux.getData());
            
            List<GeneralTree<Integer>>children = arbolAux.getChildren();
            for(GeneralTree<Integer> child: children){
                queue.enqueue(child);
                if (child)
            }
        }

    }



}
