package practica2.ejercicio5;

import practica2.ejercicio2.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> arbol;

    public ProfundidadDeArbolBinario(){
        this.arbol = new BinaryTree<>(10);

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
    public int sumaElementosProfundidad(int p) {
        BinaryTree<Integer> ab;
        Queue<BinaryTree<Integer>> cola = new LinkedList<>();
        int nivel = 0;
        cola.offer(arbol);
        int suma = 0;
        cola.offer(null);
        while (!cola.isEmpty() && (nivel < p)) {
            ab = cola.poll();
            if (ab != null) {
                suma += ab.getData();
                if (ab.hasLeftChild()) {
                    cola.offer(ab.getLeftChild());
                }
                if (ab.hasRightChild()) {
                    cola.offer(ab.getRightChild());
                }
                else {
                    if (!cola.isEmpty()) {
                        nivel++;
                        cola.offer(null);
                    }
                }
            }
            }
            return suma;

    }
    public static void main (String [] args){
        ProfundidadDeArbolBinario pr = new ProfundidadDeArbolBinario();
        System.out.println("Suma de elementos de profundidad: " +pr.sumaElementosProfundidad(5));
    }
}
