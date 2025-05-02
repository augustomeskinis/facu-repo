package practica2.ejercicio9;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree2data<T,X> {

    private T data1;
    private X data2;
    private BinaryTree2data<T,X> leftChild;
    private BinaryTree2data<T,X> rightChild;


    public BinaryTree2data() {
        super();
    }

    public BinaryTree2data(T data1,X data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    public T getData1() {
        return data1;
    }
    public X getData2 (){return data2;}

    public void setData1(T data) {
        this.data1 = data;
    }
    /**
     * Preguntar antes de invocar si hasLeftChild()
     * @return
     */
    public void setData2(X data) {
        this.data2 = data;
    }

    public BinaryTree2data<T,X> getLeftChild() {
        return leftChild;
    }
    /**
     * Preguntar antes de invocar si hasRightChild()
     * @return
     */
    public BinaryTree2data<T,X> getRightChild() {
        return this.rightChild;
    }

    public void addLeftChild(BinaryTree2data<T,X> child) {
        this.leftChild = child;
    }

    public void addRightChild(BinaryTree2data<T,X>child) {
        this.rightChild = child;
    }

    public void removeLeftChild() {
        this.leftChild = null;
    }

    public void removeRightChild() {
        this.rightChild = null;
    }

    public boolean isEmpty(){
        return (this.isLeaf() && this.getData1() == null);
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
        return this.getData1().toString() + this.getData2().toString();
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

    public BinaryTree2data<T,X> espejo(){
        if (this.hasLeftChild() && this.hasRightChild()) {
            BinaryTree2data<T,X> aux = this.getLeftChild();
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

}
