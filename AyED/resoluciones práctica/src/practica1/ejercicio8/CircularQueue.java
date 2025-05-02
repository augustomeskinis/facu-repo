package practica1.ejercicio8;

public class CircularQueue <T> extends Queue {
	public CircularQueue() {

		super();
	}
	
	 // Rota el primer elemento al final y lo retorna
    public T shift() {
        T first = (T) this.dequeue();
        this.enqueue(first);
        return first;
    }
}
