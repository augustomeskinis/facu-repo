package practica2.ejercicio9;

import practica2.ejercicio2.BinaryTree;

public class Ejercicio10 {

    public BinaryTree2data<Integer, Integer> sumAndDif(BinaryTree2data <Integer,Integer> arbol2,
                                                       BinaryTree<Integer> arbol1) {
        if (arbol2 == null){
            arbol2 = new BinaryTree2data<>();
            arbol2.setData1(arbol1.getData());
            arbol2.setData2(arbol1.getData());
        }
        if (arbol1.hasLeftChild()){
            BinaryTree2data<Integer,Integer> HI = new BinaryTree2data<>();
            HI.setData1(arbol1.getData() + arbol1.getLeftChild().getData());
            HI.setData2(arbol1.getLeftChild().getData() - arbol1.getData());
            arbol2.addLeftChild(HI);
            sumAndDif(arbol2.getLeftChild(),arbol1.getLeftChild());
        }
        if (arbol1.hasRightChild()){
            BinaryTree2data<Integer,Integer> HD = new BinaryTree2data<>();
            HD.setData1(arbol1.getData() + arbol1.getRightChild().getData());
            HD.setData2(arbol1.getRightChild().getData() - arbol1.getData());
            arbol2.addRightChild(HD);
            sumAndDif(arbol2.getRightChild(),arbol1.getRightChild());
        }
        return arbol2;
    }

    public void imprimirArbol2(BinaryTree2data<Integer,Integer> arbol){
        System.out.println("data 1: " + arbol.getData1()+ "  data2: " + arbol.getData2());
        if(arbol.hasLeftChild()){
            imprimirArbol2(arbol.getLeftChild());
        }
        if(arbol.hasRightChild()){
            imprimirArbol2(arbol.getRightChild());
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> arbol1 = new BinaryTree<>(10);
        BinaryTree<Integer> nodo1 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(4);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(7);
        arbol1.addLeftChild(nodo1);
        arbol1.addRightChild(nodo2);
        nodo1.addLeftChild(nodo4);
        BinaryTree2data<Integer,Integer> arbol2 = null;
        
        Ejercicio10 ej10 = new Ejercicio10();
        arbol2 = ej10.sumAndDif(arbol2,arbol1);
        ej10.imprimirArbol2(arbol2);

    }
}