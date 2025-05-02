package practica1.ejercicio7;


import java.util.ArrayList;

public class IncisoG {

    public static ArrayList<Integer> calcularSucesion (ArrayList<Integer> lista, int n){
        lista.add(n);
        if (n!=1){
            if (n % 2 == 0) {
                n = n / 2;
                calcularSucesion(lista,n);
            }
            else {
                n = (3 * n) + 1;
                calcularSucesion(lista,n);
            }
        }
        return lista;
    }

    public static void imprimirLista(ArrayList<Integer> lista){
        for (int i=0;i<lista.size()-1;i++){
            System.out.print(lista.get(i)+"\n");
        }
    }


    public static void main (String [] args){
        ArrayList<Integer>lista = new ArrayList<>();
        ArrayList<Integer> listaDePrueba = calcularSucesion(lista,6);
        imprimirLista(listaDePrueba);
        lista = new ArrayList<>();
        listaDePrueba = calcularSucesion(lista,8);
        imprimirLista(listaDePrueba);
    }

}
