package ParcialDesaprobadoArboles.resolucion;

import clases.BinaryTree;
import clases.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class ParcialCorrejido {

    public static List<Integer> caminoParidadAlternante (GeneralTree<Integer> arbol){
        List<Integer> caminoActual = new LinkedList<>();
        List<Integer> caminoMasLargo = new LinkedList<>();

        if ((arbol != null) && (!arbol.isEmpty())){
            if (arbol.hasChildren()) { // si el arbol solo tiene un nodo (raiz) no se lo llama, porque no hay camino posible
                buscarCamino(arbol, caminoActual, caminoMasLargo);
            }
        }
        return caminoMasLargo;
    }

    private static boolean esAlterno(int valor1, int valor2){
        boolean aux = false;
        if ((valor1 % 2) == 0){
            if ((valor2 % 2)!= 0){
                return true;
            }
        }
        else {
            if ((valor2 % 2) == 0) {
                return true;
            }
        }
        return false;
    }

    private static void buscarCamino(GeneralTree<Integer> arbol, List<Integer> caminoActual, List<Integer> caminoMasLargo){
        int valorActual = arbol.getData();
        caminoActual.add(valorActual);

        if (arbol.isLeaf()) {
            if (caminoActual.size() > caminoMasLargo.size()) {
                    caminoMasLargo.clear();
                    caminoMasLargo.addAll(caminoActual);
            }
        }
        else{
            for(GeneralTree<Integer> child: arbol.getChildren()){
                int valorHijo = child.getData();
                if (esAlterno(valorActual,valorHijo)){
                    buscarCamino(child,caminoActual,caminoMasLargo);
                }
            }
        }
        caminoActual.remove(caminoActual.size()-1);
    }
    public static void main(String[] args) {
        /*             1
                /     |     \
               4       3       2
              / \     / \     / \
             5   6   8   7   9  10
                     |
                     11
        */

        // Crear nodos
        GeneralTree<Integer> raiz = new GeneralTree<>(1);  // impar

        GeneralTree<Integer> n4 = new GeneralTree<>(4);    // par
        GeneralTree<Integer> n3 = new GeneralTree<>(3);    // impar
        GeneralTree<Integer> n2 = new GeneralTree<>(2);    // par

        GeneralTree<Integer> n5 = new GeneralTree<>(5);    // impar
        GeneralTree<Integer> n6 = new GeneralTree<>(6);    // par

        GeneralTree<Integer> n8 = new GeneralTree<>(8);    // par
        GeneralTree<Integer> n7 = new GeneralTree<>(7);    // impar
        GeneralTree<Integer> n11 = new GeneralTree<>(11);  // impar

        GeneralTree<Integer> n9 = new GeneralTree<>(9);    // impar
        GeneralTree<Integer> n10 = new GeneralTree<>(10);  // par

        // Armar árbol
        raiz.addChild(n4);
        raiz.addChild(n3);
        raiz.addChild(n2);

        n4.addChild(n5);
        n4.addChild(n6);

        n3.addChild(n8);
        n3.addChild(n7);

        n8.addChild(n11);

        n2.addChild(n9);
        n2.addChild(n10);

        // Ejecutar búsqueda
        List<Integer> camino = ParcialCorrejido.caminoParidadAlternante(raiz);

        // Imprimir resultado
        System.out.println("Camino más largo con paridad alternante:");
        for (int val : camino) {
            System.out.println(val);
        }
}
}
