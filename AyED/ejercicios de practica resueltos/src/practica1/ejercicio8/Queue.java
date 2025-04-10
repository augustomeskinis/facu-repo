package practica1.ejercicio8;
import java.util.LinkedList;
public class Queue {
	private LinkedList<Integer> lista;
	
	//Constructor
	public Queue() {
		lista = new LinkedList<>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);
	}
	//Inserta el elemento al final de la cola
	public void enqueue(int dato) {
		lista.add(dato);
	}
	//Elimina el elemento del frente de la cola
	public int dequeue() {
		if (lista.isEmpty()) {
			System.out.println("Esta vacía");
			return -1;
		}
		return lista.remove(0);
	}
	//Retorna el elemento del frente de la cola
	public int head() {
		if (lista.isEmpty()) {
			System.out.println("Esta vacía");
			return -1;
		}
		return lista.get(0);
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
	
	public LinkedList<Integer> devolverLista(){
		return this.lista;
	}
}
