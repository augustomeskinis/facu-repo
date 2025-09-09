package clases;
import java.util.LinkedList;

public class Queue<T> {
	private LinkedList<T> lista;
	
	//Constructor
	public Queue() {
		lista = new LinkedList<>();
	}
	//Inserta el elemento al final de la cola
	public void enqueue(T dato) {
		lista.add(dato);
	}

	//Elimina el elemento del frente de la cola
	public T dequeue() {
		return lista.removeFirst();
	}
	//Retorna el elemento del frente de la cola
	public T head() {
		return lista.getFirst();
	}
	//Verdadero si esta vacía, Falso si no
	public boolean isEmpty() {

		return lista.isEmpty();
	}
	//Cantidad de elementos de la cola
	public int size() {

		return lista.size();
	}
	@Override
	//Elementos de la cola en un String
	public String toString() {
		return lista.toString();
	}

	public LinkedList<T> getLista(){
		return lista;
	}
}
