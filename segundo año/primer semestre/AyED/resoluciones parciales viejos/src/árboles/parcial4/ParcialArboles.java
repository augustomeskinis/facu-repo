package árboles.parcial4;

import clases.GeneralTree;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ParcialArboles {

    GeneralTree<Integer> arbol;


    public List<Integer> camino (int num){
        List<Integer>camino = new LinkedList<>();
        if (this.arbol!=null && !arbol.isEmpty() && arbol.getChildren().size() > num){
            realizarCamino(arbol,num,camino);
        }
        return camino;
    }

    public boolean realizarCamino (GeneralTree<Integer> nodoActual, int num,List<Integer> camino){
        camino.add(nodoActual.getData());
        boolean encontre = false;

        if (nodoActual.isLeaf()){
            encontre = true;
        }

        else {
            List<GeneralTree<Integer>> hijos = nodoActual.getChildren();
            Iterator<GeneralTree<Integer>> it = hijos.iterator();
            while ( !encontre && it.hasNext() ){
                GeneralTree<Integer> hijo = it.next();
                if (hijo.getChildren().size() > num) {
                    encontre = realizarCamino(hijo,num,camino);
                }
            }
            if (!encontre) {
                camino.remove(camino.size() - 1);
            }
        }

        return encontre;
    }

}
