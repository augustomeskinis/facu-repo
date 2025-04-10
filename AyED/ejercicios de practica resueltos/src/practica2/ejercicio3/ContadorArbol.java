package practica2.ejercicio3;

import practica2.ejercicio2.BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class ContadorArbol {
    private BinaryTree<Integer> arbol;

    public ContadorArbol (){
        this.arbol = new BinaryTree<Integer>(40);
        BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
        hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
        hijoIzquierdo.addRightChild(new BinaryTree<Integer>(32));
        BinaryTree<Integer> hijoDerecho= new BinaryTree<Integer>(78);
        arbol.addLeftChild(hijoIzquierdo);
        arbol.addRightChild(hijoDerecho);
    }

    public List<Integer> contadorArbolIncisoA(){
        List<Integer> lista = new LinkedList<>();
        this.preOrden(this.arbol, lista);
        return lista;
    }

    private void preOrden (BinaryTree<Integer> ab, List lista){
        if (ab.getData() % 2 == 0){
            lista.add(ab.getData());
        }
        if (ab.hasLeftChild()){
            preOrden(ab.getLeftChild(),lista);
        }
        if(ab.hasRightChild()){
            preOrden(ab.getRightChild(),lista);
        }
    }
    public List<Integer> contadorArbolIncisoB(){
        List<Integer>lista = new LinkedList<>();
        this.postOrden(arbol,lista);
        return lista;
    }

    private void postOrden (BinaryTree<Integer> ab, List lista){
        if (ab.hasLeftChild()){
            postOrden(ab.getLeftChild(),lista);
        }
        if(ab.hasRightChild()){
            postOrden(ab.getRightChild(),lista);
        }
        if (ab.getData() % 2 == 0){
            lista.add(ab.getData());
        }
    }

    public static void main (String [] args){
        ContadorArbol contador = new ContadorArbol();
        System.out.println ("lista numero pre orden");
        List lista = contador.contadorArbolIncisoA();
        lista.forEach(System.out::println);
        lista = contador.contadorArbolIncisoB();
        lista.forEach(System.out::println);
    }

}
