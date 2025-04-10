package practica2.ejercicio4;

import practica2.ejercicio2.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class RedBinariaLlena {

    /* el enfoque correcto en este problema es hacer un recorrido en profundidad
    sumando los valores de los nodos a medida que avanzamos en cada camino.
     no un recorrido por niveles que usa una cola (Queue) para recorrer el árbol por niveles,
     lo que no es adecuado para encontrar el camino con la suma más grande.
    el camino con la suma más grande no  pasa por los valores máximos de cada nivel.
     */

    private BinaryTree<Integer> arbol;

    public RedBinariaLlena (){
        arbol = new BinaryTree<>(10);

        BinaryTree<Integer> node2 = new BinaryTree<>(2);
        BinaryTree<Integer> node3 = new BinaryTree<>(3);
        arbol.addLeftChild(node2);
        arbol.addRightChild(node3);

        BinaryTree<Integer> node5 = new BinaryTree<>(5);
        BinaryTree<Integer> node4 = new BinaryTree<>(4);
        node2.addLeftChild(node5);
        node2.addRightChild(node4);

        BinaryTree<Integer> node9 = new BinaryTree<>(9);
        BinaryTree<Integer> node8 = new BinaryTree<>(8);
        node3.addLeftChild(node9);
        node3.addRightChild(node8);

        node5.addLeftChild(new BinaryTree<>(7));
        node5.addRightChild(new BinaryTree<>(8));

        node4.addLeftChild(new BinaryTree<>(5));
        node4.addRightChild(new BinaryTree<>(6));

        node9.addLeftChild(new BinaryTree<>(12));
        node9.addRightChild(new BinaryTree<>(8));

        node8.addLeftChild(new BinaryTree<>(2));
        node8.addRightChild(new BinaryTree<>(1));
    }


    public int retardoEnvio() {
        return retardoEnvioHelper(arbol);
    }

    private int retardoEnvioHelper(BinaryTree<Integer> nodo) {
        if (nodo == null) return 0;  // Si el nodo es nulo, no aporta suma

        int izquierda = retardoEnvioHelper(nodo.getLeftChild());
        int derecha = retardoEnvioHelper(nodo.getRightChild());

        return nodo.getData() + Math.max(izquierda, derecha); // Elegimos el camino con mayor suma
    }


    public static void main (String [] args){
        RedBinariaLlena red = new RedBinariaLlena();
        System.out.println ("el recorrido mas largo es: " + red.retardoEnvio());
    }

}
