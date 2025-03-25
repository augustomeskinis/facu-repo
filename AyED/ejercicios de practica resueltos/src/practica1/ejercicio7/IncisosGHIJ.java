package practica1.ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class IncisosGHIJ {

    ArrayList<Integer> lista = new ArrayList<>();

    public List<Integer> calcularSucesion (int n){
        if (n!=1){
            if (n % 2 == 0) {
                n /= 2;
                calcularSucesion(n);
            } else {
                n = 3 * n + 1;
                calcularSucesion(n);
            }
        }
        return lista;
    }

    public void invertirArrayList(ArrayList<Integer> lista){

    }
}
