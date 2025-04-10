package practica1.ejercicio7;

import java.util.ArrayList;

public class IncisoF {
    public static boolean esCapicua(ArrayList<Integer> lista){
        int i = 0, j = lista.size() - 1;
        while (i < j) {
            if (!lista.get(i).equals(lista.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList<Integer> lista1 = new ArrayList<>();
        lista1.add(1);
        lista1.add(2);
        lista1.add(3);
        lista1.add(2);
        lista1.add(1);

        System.out.println("¿Es capicúa? " + esCapicua(lista1)); // true

        ArrayList<Integer> lista2 = new ArrayList<>();
        lista2.add(1);
        lista2.add(2);
        lista2.add(3);

        System.out.println("¿Es capicúa? " + esCapicua(lista2)); // false
    }
}
