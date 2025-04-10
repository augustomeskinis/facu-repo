package practica1.ejercicio7;

import java.util.ArrayList;

public class IncisoH {


    public static void invertirArrayList(ArrayList<Integer> lista){
        int i; int aux1,aux2; int j = lista.size()-1;
        for (i=0;i< lista.size() / 2 ;i++){
            aux1 = lista.get(i);
            aux2 = lista.get(j);
            lista.set(j,aux1);
            lista.set(i,aux2);
            j--;
        }
    }

    public static void imprimirLista(ArrayList<Integer> lista){
        for (int i=0;i<lista.size();i++){
            System.out.print(lista.get(i)+"\n");
        }
    }

    public static void main (String [] args){
        ArrayList<Integer>lista = new ArrayList<>();
        lista.add(1);lista.add(2);lista.add(3);lista.add(4);lista.add(5);
        invertirArrayList(lista);
        imprimirLista(lista);
    }
}
