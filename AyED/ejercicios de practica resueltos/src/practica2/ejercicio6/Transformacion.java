package practica2.ejercicio6;

import practica2.ejercicio2.BinaryTree;

public class Transformacion {
    private BinaryTree<Integer> ab;

    public Transformacion() {
        // Creamos la raíz con valor 1
        this.ab = new BinaryTree<>(1);

        // Construimos el árbol como en el ejemplo
        BinaryTree<Integer> node2 = new BinaryTree<>(2);
        BinaryTree<Integer> node3 = new BinaryTree<>(3);
        this.ab.addLeftChild(node2);
        this.ab.addRightChild(node3);

        BinaryTree<Integer> node4 = new BinaryTree<>(4);
        node2.addRightChild(node4);

        BinaryTree<Integer> node5 = new BinaryTree<>(5);
        BinaryTree<Integer> node6 = new BinaryTree<>(6);
        node3.addLeftChild(node5);
        node3.addRightChild(node6);

        BinaryTree<Integer> node7 = new BinaryTree<>(7);
        BinaryTree<Integer> node8 = new BinaryTree<>(8);

        node5.addLeftChild(node7);
        node5.addRightChild(node8);
    }

    public BinaryTree<Integer> getArbolDeInstancia() {
        return this.ab;
    }

    public BinaryTree<Integer> suma(BinaryTree<Integer> arbol) {
        transformar(arbol);
        return arbol;
    }

    private int transformar(BinaryTree<Integer> nodo) {
        if (nodo == null) {
            return 0;
        }

        int valorOriginal = nodo.getData(); // Guardamos el valor actual

        int sumaIzquierda = transformar(nodo.getLeftChild());
        int sumaDerecha = transformar(nodo.getRightChild());

        nodo.setData(sumaIzquierda + sumaDerecha); // Cambiamos el valor por la suma de sus subárboles
        return nodo.getData() + valorOriginal; // Devolvemos el total (para que el padre lo use)
    }

    public void preorden(BinaryTree<Integer> ab) {
        System.out.println(ab.getData());
        if (ab.hasLeftChild()) {
            this.preorden(ab.getLeftChild());
        }
        if (ab.hasRightChild()) {
            this.preorden(ab.getRightChild());
        }
    }

    // Método para imprimir el árbol de forma visual en consola
    public void imprimirArbol(BinaryTree<Integer> nodo, int nivel) {
        if (nodo == null) return;

        imprimirArbol(nodo.getRightChild(), nivel + 1);

        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }
        System.out.println(nodo.getData());

        imprimirArbol(nodo.getLeftChild(), nivel + 1);
    }

    public static void main(String[] args) {
        Transformacion transf = new Transformacion();

        System.out.println("Árbol original (Preorden):");
        transf.preorden(transf.getArbolDeInstancia());

        System.out.println("\nÁrbol transformado (Preorden):");
        transf.suma(transf.getArbolDeInstancia());
        transf.preorden(transf.getArbolDeInstancia());

        System.out.println("\nÁrbol transformado (Visual):");
        transf.imprimirArbol(transf.getArbolDeInstancia(), 0);
    }
}

