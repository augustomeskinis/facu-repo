package practica1.ejercicio7;


import java.util.LinkedList;

public class Incisoi {
    public static int sumarLinkedList(int pos, int suma, LinkedList<Integer> lista){
        if (pos < lista.size()) {
            suma += lista.get(pos);
            pos++;
            return sumarLinkedList(pos,suma,lista);
        }
       return suma;
    }

    public static void main (String [] args){
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(5);lista.add(10);lista.add(5);
        System.out.println("suma: ");
        System.out.println(sumarLinkedList(0,0,lista));
    }

}
