package practica1.ejercicio8;

public class main {
	public static void main(String[] args) {
        Queue <Integer> cola = new Queue();

        System.out.println("¿Cola vacía? " + cola.isEmpty()); // true

        System.out.println("\nEncolando elementos:");
        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);
        System.out.println("Cola: " + cola); // [10, 20, 30]
        System.out.println("Tamaño: " + cola.size()); // 3

        System.out.println("\nPrimer elemento (head): " + cola.head()); // 10

        System.out.println("\nDesencolando elemento: " + cola.dequeue()); // 10
        System.out.println("Cola después del dequeue: " + cola); // [20, 30]

        System.out.println("\n¿Cola vacía? " + cola.isEmpty()); // false
    }
}
