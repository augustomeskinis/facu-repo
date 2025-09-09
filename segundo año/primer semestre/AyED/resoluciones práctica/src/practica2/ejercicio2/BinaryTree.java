package practica2.ejercicio2;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <T> {

    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;


    public BinaryTree() {
        super();
    }

    public BinaryTree(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    /**
     * Preguntar antes de invocar si hasLeftChild()
     * @return
     */
    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }
    /**
     * Preguntar antes de invocar si hasRightChild()
     * @return
     */
    public BinaryTree<T> getRightChild() {
        return this.rightChild;
    }

    public void addLeftChild(BinaryTree<T> child) {
        this.leftChild = child;
    }

    public void addRightChild(BinaryTree<T> child) {
        this.rightChild = child;
    }

    public void removeLeftChild() {
        this.leftChild = null;
    }

    public void removeRightChild() {
        this.rightChild = null;
    }

    public boolean isEmpty(){
        return (this.isLeaf() && this.getData() == null);
    }

    public boolean isLeaf() {
        return (!this.hasLeftChild() && !this.hasRightChild());

    }

    public boolean hasLeftChild() {
        return this.leftChild!=null;
    }

    public boolean hasRightChild() {
        return this.rightChild!=null;
    }
    @Override
    public String toString() {
        return this.getData().toString();
    }

    public  int contarHojas(int cant) {
        cant++;
        if (this.hasLeftChild()){
            this.leftChild.contarHojas(cant);
        }
        if (this.hasRightChild()){
            this.rightChild.contarHojas(cant);
        }
        return cant;
    }

    public BinaryTree<T> espejo(){
        if (this.hasLeftChild() && this.hasRightChild()) {
            BinaryTree<T> aux = this.getLeftChild();
            this.leftChild = this.rightChild;
            this.rightChild = aux;
        }
        if (this.hasLeftChild()){
            this.leftChild.espejo();
        }
        if (this.hasRightChild()){
            this.rightChild.espejo();
        }
        return this;
    }

    // 0<=n<=m
    public void entreNiveles(int n, int m){
        Queue<BinaryTree<T>> cola = new LinkedList<>();
        cola.offer(this);
        cola.offer(null); // marca de nivel
        int nivel = 1;

        while (!cola.isEmpty()){
            BinaryTree<T> ab = cola.poll();
            if (ab != null){
                if (n<=nivel && nivel<=m){
                    System.out.println(this.data);
                }
                if (ab.hasLeftChild()){
                    cola.offer(ab.leftChild);
                }
                if (ab.hasRightChild()){
                    cola.offer(ab.rightChild);
                }
            }
            else if (!cola.isEmpty()){
                System.out.println();
                cola.offer(null);
                nivel++;
            }
        }
    }
}
