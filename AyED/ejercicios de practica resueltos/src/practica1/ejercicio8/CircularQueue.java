package practica1.ejercicio8;

public class CircularQueue extends Queue {
	public CircularQueue() {
		super();
	}
	
	 // Rota el primer elemento al final y lo retorna
    public int shift() {
        if (isEmpty()) {
            System.out.print("La cola está vacía");
            return -1;
        }
        int first = dequeue();
        enqueue(first);
        return first;
    }
}
