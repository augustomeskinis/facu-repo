package practica3.ejercicio9;

import practica3.ejercicio1.GeneralTree;

public class Ejercicio9 {

    /* preguntar: 1. por qué tiene que ser static el métoodo?
    *             2. está bien? funciona                                   */


    public static boolean esDeSeleccion(GeneralTree<Integer>arbol){
        boolean es = false; boolean sonHijos = true; int min = 9999;
        for (GeneralTree<Integer>child: arbol.getChildren()){
            if (!child.isLeaf()){
                sonHijos =esDeSeleccion (child);
            }
            if (child.getData() <= min){
                min = child.getData();
            }
        }
        int dataNodoActual = arbol.getData();
        if (min == dataNodoActual){
            es = true;
        }
        return (es && sonHijos);
    }

    public static void main (String [] args){
        GeneralTree<Integer> arbol = new GeneralTree<>(12);

        GeneralTree<Integer> nodo1 = new GeneralTree<>(12);
        GeneralTree<Integer> nodo2 = new GeneralTree<>(13);
        GeneralTree<Integer> nodo3 = new GeneralTree<>(14);
        arbol.addChild(nodo1);
        arbol.addChild(nodo2);
        arbol.addChild(nodo3);


        Ejercicio9 ej9 = new Ejercicio9();
        System.out.println("Es de selección? "+ ej9.esDeSeleccion(arbol));
    }


}
