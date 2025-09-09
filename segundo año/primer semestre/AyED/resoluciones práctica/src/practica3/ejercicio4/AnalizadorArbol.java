package practica3.ejercicio4;

import practica3.ejercicio3.GeneralTree;
import java.util.LinkedList;
import java.util.List;
import practica1.ejercicio8.Queue;

/*
    RESPUESTA PUNTO 1) A). ES UN RECORRIDO POR NIVELES UTILIZANDO LA COLA CREADA EN LA EJ8P1
    NOTA: EL ARBOL CREADO EN EL MAIN ES EL DE LA FIGURA DEL ENUNCIADO EJ4P3 SIN EL ULTIMO NIVEL
 */


public class AnalizadorArbol {

    public double devolverMaximoPromedio (GeneralTree<AreaEmpresa> arbol){
        int promedio; double maxPromedio = -1;
        GeneralTree<AreaEmpresa>treeAux;

        Queue<GeneralTree<AreaEmpresa>> queue = new Queue<>();
        queue.enqueue(arbol);
        while (!queue.isEmpty()) {
            int size = queue.size();
            promedio = 0;
            for (int i=0; i<size; i++){
                treeAux = queue.dequeue();
                promedio += treeAux.getData().getTardanza();
                for (GeneralTree<AreaEmpresa> child: treeAux.getChildren()){
                    queue.enqueue(child);
                }
            }
            promedio /= size;
            if (promedio > maxPromedio){
                maxPromedio  = promedio;
            }
        }
        return maxPromedio;
    }

    public static void main (String [] args){
        GeneralTree<AreaEmpresa> arbol = new GeneralTree<>();
        AreaEmpresa areaEmpresa = new AreaEmpresa("area 0", 14);
        arbol.setData(areaEmpresa);

        GeneralTree<AreaEmpresa> nodo1punto1 = new GeneralTree<>();
        AreaEmpresa areaEmpresa1punto1 = new AreaEmpresa("area 1.1", 13);
        nodo1punto1.setData(areaEmpresa1punto1);

        GeneralTree<AreaEmpresa> nodo1punto2 = new GeneralTree<>();
        AreaEmpresa areaEmpresa1punto2 = new AreaEmpresa("area 1.2", 25);
        nodo1punto2.setData(areaEmpresa1punto2);

        GeneralTree<AreaEmpresa> nodo1punto3 = new GeneralTree<>();
        AreaEmpresa areaEmpresa1punto3 = new AreaEmpresa("area 1.3", 10);
        nodo1punto3.setData(areaEmpresa1punto3);

        arbol.addChild(nodo1punto1); arbol.addChild(nodo1punto2); arbol.addChild(nodo1punto3);

        AnalizadorArbol analizadorArbol = new AnalizadorArbol();
        System.out.println("promedio de tardanza mayor entre todos los niveles: "+ analizadorArbol.devolverMaximoPromedio(arbol));

    }
}
