package árboles.parcial2;
import clases.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class Resolución {

    public static boolean esAlterno(int dataPadre, int dataHijo) {
        if (((dataPadre % 10 == 0) && (dataHijo % 10 != 0)) | ((dataPadre % 10 != 0) && (dataHijo % 10 == 0))){
            return true;
        }
        return false;
    }


    public static List<Integer> caminoAlternanteCeroNoCero (GeneralTree<Integer> arbol){
        List<Integer> primerCamino = new LinkedList<>();
        List<Integer> camino = new LinkedList<>();
        if ((arbol != null) && (!arbol.isEmpty())){
            camino = resolver(arbol,primerCamino);
        }
        return camino;
    }

    public static List<Integer> resolver(GeneralTree<Integer> arbol, List<Integer> primerCamino) {
        int data = arbol.getData();
        primerCamino.add(data);

        if (arbol.isLeaf()) {
            return primerCamino;  // Camino válido encontrado
        }

        List<GeneralTree<Integer>> hijos = arbol.getChildren();
        for (GeneralTree<Integer> hijo : hijos) {
            if (esAlterno(data, hijo.getData())) {
                List<Integer> caminoEncontrado = resolver(hijo, primerCamino);
                if (!caminoEncontrado.isEmpty()) {  // Si encontró un camino válido
                    return caminoEncontrado;
                }
            }
        }

        // Backtracking: si ningún hijo generó un camino válido
        primerCamino.remove(primerCamino.size() - 1);
        return new LinkedList<>();  // Retornar lista vacía si no hay camino
    }

}
