package practica1.ejercicio8;
import java.util.LinkedList;
public class DoubleEndedQueue <T> extends Queue{

    //Inserta un elemento al inicio de la cola
    public void enqueueFirst(T data) {
        super.getLista().addFirst(data);
    }


}
