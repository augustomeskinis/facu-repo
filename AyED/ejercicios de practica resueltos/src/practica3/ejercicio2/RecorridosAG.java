package practica3.ejercicio2;

import practica3.ejercicio1.GeneralTree;

import java.util.LinkedList;
import java.util.List;
import  practica1.ejercicio8.Queue;


public class RecorridosAG {

    public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree<Integer> a,
                                                           Integer n){
        LinkedList<Integer> lista = new LinkedList<>();
        if (a!= null && !a.isEmpty()) crearListaPreOrden(a,n,lista);
        return lista;
    }

    public List <Integer> crearListaPreOrden (GeneralTree<Integer>a,Integer n, LinkedList<Integer> lista){
        if (a.getData() % 2 !=0 && a.getData() > n) lista.add(a.getData());
        List <GeneralTree<Integer>> children = a.getChildren();
        for (GeneralTree<Integer>child: children){
            crearListaPreOrden(child,n,lista);
        }
        return lista;
    }

    public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,
                                                          Integer n){
        LinkedList<Integer> lista = new LinkedList<>();
        if (a!= null && !a.isEmpty()) crearListaInOrden(a,n,lista);
        return lista;
    }

    public List<Integer> crearListaInOrden (GeneralTree<Integer>a,Integer n, LinkedList<Integer> lista){
        List<GeneralTree<Integer>> children = a.getChildren();
        if (children != null) {
            GeneralTree<Integer> primerHijo = children.getFirst();
            children.removeFirst();
            if (primerHijo.getData() % 2 != 0 && a.getData() > n) lista.add(primerHijo.getData());
        }
        if(a.getData() % 2 != 0 && a.getData() > n) lista.add(a.getData());
        for (GeneralTree<Integer>child: children){
            crearListaInOrden(child,n,lista);
        }
        return lista;
    }

    public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,
                                                            Integer n){
        LinkedList<Integer> lista = new LinkedList<>();
        if (a!= null && !a.isEmpty()) crearListaPostOrden(a,n,lista);
        return lista;
    }

    public List<Integer> crearListaPostOrden (GeneralTree<Integer> a, Integer n, LinkedList<Integer> lista){
        List <GeneralTree<Integer>> children = a.getChildren();
        for (GeneralTree<Integer>child: children){
            crearListaPreOrden(child,n,lista);
        }
        if (a.getData() % 2 !=0 && a.getData() > n) lista.add(a.getData());
        return lista;
    }

    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,
                                                            Integer n){
        List <Integer> lista = new LinkedList<>();
        GeneralTree<Integer> tree_aux;

        Queue<GeneralTree<Integer>> queue = new Queue<>();
        queue.enqueue(a);
        while (!queue.isEmpty()){
            tree_aux = queue.dequeue();
            if (a.getData() % 2 !=0 && a.getData() > n) lista.add(a.getData());
            List<GeneralTree<Integer>> children = tree_aux.getChildren();
            for (GeneralTree<Integer> child: children){
                queue.enqueue(child);
            }
        }
        return lista;
    }


}
