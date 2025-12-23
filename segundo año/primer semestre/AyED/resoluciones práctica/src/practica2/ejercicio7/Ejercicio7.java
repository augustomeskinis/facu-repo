package practica2.ejercicio7;
import practica2.ejercicio2.BinaryTree;
public class Ejercicio7 {
    private BinaryTree<Integer> arbol;

    public Ejercicio7() {
        this.arbol = new BinaryTree<>(2);
        BinaryTree<Integer> nodo2 = new BinaryTree(7);
        BinaryTree<Integer> nodo3 = new BinaryTree(-5);

        this.arbol.addLeftChild(nodo2);
        this.arbol.addRightChild(nodo3);

        BinaryTree<Integer> nodo4 = new BinaryTree(23);
        BinaryTree<Integer> nodo5 = new BinaryTree(6);

        nodo2.addLeftChild(nodo4);
        nodo2.addRightChild(nodo5);

        BinaryTree<Integer> nodo6 = new BinaryTree(19);
        nodo3.addLeftChild(nodo6);

        BinaryTree<Integer> nodo7 = new BinaryTree(-3);
        nodo4.addLeftChild(nodo7);

        BinaryTree<Integer> nodo8 = new BinaryTree(55);
        BinaryTree<Integer> nodo9 = new BinaryTree(11);

        nodo5.addLeftChild(nodo8);
        nodo5.addRightChild(nodo9);

        BinaryTree<Integer> nodo10 = new BinaryTree(4);
        nodo6.addRightChild(nodo10);

        BinaryTree<Integer> nodo11 = new BinaryTree(18);
        nodo10.addLeftChild(nodo11);
    }

    public BinaryTree<Integer> buscarNodo(BinaryTree<Integer> ab, int num) {
        boolean encontre = false;
        BinaryTree<Integer> arbol = null;
        if (ab.getData() == num) {
            arbol = ab;
            encontre = true;
        }
        if (ab.hasLeftChild() && !encontre) {
            arbol = buscarNodo(ab.getLeftChild(), num);
            if (arbol != null) {
                encontre = true;
            }
        }
        if (ab.hasRightChild() && !encontre) {
            arbol = buscarNodo(ab.getRightChild(), num);
        }
        return arbol;
    }

    public int calcularHijos(BinaryTree<Integer> ab, int suma) {
        if (ab.hasLeftChild() && !ab.hasRightChild()) {
            calcularHijos(ab.getLeftChild(), suma++);
        } else {
            if (!ab.hasLeftChild() && ab.hasRightChild()) {
                calcularHijos(ab.getRightChild(), suma++);
            } else {
                if (ab.hasLeftChild() && ab.hasRightChild()) {
                    calcularHijos(ab.getLeftChild(), suma);
                    calcularHijos(ab.getRightChild(), suma);
                }
            }
        }
        return suma;
    }

    public boolean tieneMas(BinaryTree<Integer> ab) {
        int suma = 0, sumaI = 0, sumaD = 0;
        if (ab.hasLeftChild()) {
            sumaI = calcularHijos(ab.getLeftChild(), suma);
        }
        suma = 0;
        if (ab.hasRightChild()) {
            sumaD = calcularHijos(ab.getRightChild(), suma);
        }
        return sumaI > sumaD;
    }

    public boolean isLeftTree(int num) {
        BinaryTree<Integer> arbolNum = this.buscarNodo(this.arbol, num);
        if (arbolNum == null) {
            System.out.println("no encontre el nodo: " + num);
            return false;
        }
        System.out.println("encontre el nodo: " + arbolNum.getData());
        return tieneMas(arbolNum);
    }

    public static void main(String[] args) {
        Ejercicio7 ej7 = new Ejercicio7();
        System.out.println("tiene más hijos?" + ej7.isLeftTree(14));
    }
}