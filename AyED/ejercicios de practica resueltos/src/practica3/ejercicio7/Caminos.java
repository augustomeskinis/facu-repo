package practica3.ejercicio7;

import practica3.ejercicio5.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class Caminos {
    private GeneralTree<Integer> arbol;

    public Caminos() {
        this.arbol = new GeneralTree<>(12);

        GeneralTree<Integer> nodo1 = new GeneralTree<>(10);
        GeneralTree<Integer> nodo2 = new GeneralTree<>(9);
        GeneralTree<Integer> nodo3 = new GeneralTree<>(8);

        arbol.addChild(nodo1);
        arbol.addChild(nodo2);
        arbol.addChild(nodo3);

        GeneralTree<Integer> nodo4 = new GeneralTree<>(7);
        nodo1.addChild(nodo4);

    }

    public List<Integer> caminoAHojaMasLejana() {
        List<Integer> caminoActual = new LinkedList<>();
        List<Integer> caminoMasLargo = new LinkedList<>();

        if (arbol != null && !arbol.isEmpty()) {
            buscarCaminoMasLargo(arbol, caminoActual, caminoMasLargo);
        }

        return caminoMasLargo;
    }

    private void buscarCaminoMasLargo(GeneralTree<Integer> nodo,
                                      List<Integer> caminoActual,
                                      List<Integer> caminoMasLargo) {
        // Agregar el dato del nodo actual al camino
        caminoActual.add(nodo.getData());

        // Si es hoja, comparar con el camino más largo encontrado hasta ahora
        if (nodo.isLeaf()) {
            if (caminoActual.size() > caminoMasLargo.size()) {
                caminoMasLargo=caminoActual;
            }
        } else {
            // Recorrer todos los hijos
            for (GeneralTree<Integer> hijo : nodo.getChildren()) {
                buscarCaminoMasLargo(hijo, caminoActual, caminoMasLargo);
            }
        }

        // Retroceder: eliminar el nodo actual del camino antes de volver
        caminoActual.remove(caminoActual.size() - 1);
    }


    public static void main(String[] args) {
        Caminos c = new Caminos();
        List<Integer> lista = c.caminoAHojaMasLejana();
        System.out.println("tamaño de la lista = " + lista.size() + "\n");
        lista.forEach(System.out::println);
    }


}
