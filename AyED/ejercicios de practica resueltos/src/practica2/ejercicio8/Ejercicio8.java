package practica2.ejercicio8;

import practica2.ejercicio2.BinaryTree;

public class Ejercicio8 {

    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
        boolean es = true;

        if (!arbol1.getData().equals(arbol2.getData())) {
            es = false;
        }

        if (arbol1.hasLeftChild()) {
            if (!arbol2.hasLeftChild()) {
                es = false;
            } else {
                es = es && esPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild());
            }
        }

        if (arbol1.hasRightChild()) {
            if (!arbol2.hasRightChild()) {
                es = false;
            } else {
                es = es && esPrefijo(arbol1.getRightChild(), arbol2.getRightChild());
            }
        }

        return es;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> arbol1 = new BinaryTree<>(1);

        BinaryTree<Integer> nodo1 = new BinaryTree<>(2);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(3);

        arbol1.addLeftChild(nodo1);
        arbol1.addRightChild(nodo2);


        BinaryTree<Integer> arbol2 = new BinaryTree<>(1);

        BinaryTree<Integer> nodo3 = new BinaryTree<>(2);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(3);

        arbol2.addLeftChild(nodo3);
        arbol2.addRightChild(nodo4);

        BinaryTree<Integer> nodo5 = new BinaryTree<>(4);
        nodo3.addRightChild(nodo5);

        Ejercicio8 ej8 = new Ejercicio8();
        System.out.println("Es Prefijo: " + ej8.esPrefijo(arbol1,arbol2)); // deberia devolver true

        nodo2.setData(0);
        System.out.println("Es Prefijo: " + ej8.esPrefijo(arbol1,arbol2)); // deberia devolver false
    }
}