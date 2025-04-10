package practica1.ejercicio8;
import java.util.LinkedList;
public class DoubleEndedQueue extends Queue{

    // Constructor
    public DoubleEndedQueue() {
        super();
    }
    
    //Inserta un elemento al inicio de la cola
    public void enqueueFirst(int data) {
        super.devolverLista().addFirst(data);
    }
    
    public static void main(String[] args) {
    	DoubleEndedQueue deq = new DoubleEndedQueue();

        deq.enqueue(100);
        deq.enqueue(200);
        System.out.println("Cola después de encolar 100 y 200: " + deq);

        deq.enqueueFirst(500);
        System.out.println("Cola después de enqueueFirst(500): " + deq);

        deq.enqueue(600);
        System.out.println("Cola final: " + deq);
    }
    
    
}
