package árboles.parcial5;

import clases.BinaryTree;

public class ParcialArboles {
    private BinaryTree<Integer> arbol;

    public BinaryTree<Integer> nuevoTree(){
        BinaryTree<Integer> nuevoArbol = new BinaryTree<>();

        if (this.arbol != null && !this.arbol.isEmpty()){
            recorrido(this.arbol, nuevoArbol,0);
        }
        return nuevoArbol;
    }

    private void recorrido (BinaryTree<Integer> nodoActual, BinaryTree<Integer> nuevoNodo, int valorPadre){

        if (nodoActual.hasLeftChild()) {
            BinaryTree<Integer> hI = new BinaryTree<>();
            nuevoNodo.addLeftChild(hI);
            recorrido(nodoActual.getLeftChild(), hI, nodoActual.getData());
        }

        if (nodoActual.hasRightChild()) {
            BinaryTree<Integer> hD = new BinaryTree<>();
            nuevoNodo.addRightChild(hD);
            recorrido(nodoActual.getRightChild(), hD, nodoActual.getData());
        }

        nuevoNodo.setData(nodoActual.getData() + valorPadre);
    }

}
