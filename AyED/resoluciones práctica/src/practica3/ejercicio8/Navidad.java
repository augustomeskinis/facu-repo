package practica3.ejercicio8;

import practica3.ejercicio5.GeneralTree;

public class Navidad {
    private GeneralTree<Integer> arbol;

    public Navidad (){ /* el nodo raiz tiene 3 hijos hojas, y el nodo 1
                            (que no es hoja) tiene 3 hijos hojas, por lo tanto es abeto */
        this.arbol = new GeneralTree<>(1);

        GeneralTree<Integer>nodo1 = new GeneralTree<>(2);
        GeneralTree<Integer>nodo2 = new GeneralTree<>(2);
        GeneralTree<Integer>nodo3 = new GeneralTree<>(2);
        GeneralTree<Integer>nodo4 = new GeneralTree<>(2);

        arbol.addChild(nodo1);
        arbol.addChild(nodo2);
        arbol.addChild(nodo3);
        arbol.addChild(nodo4);

        GeneralTree<Integer>nodo5 = new GeneralTree<>(2);
        GeneralTree<Integer>nodo6 = new GeneralTree<>(2);
        GeneralTree<Integer>nodo7 = new GeneralTree<>(2);

        nodo1.addChild(nodo5);
        nodo1.addChild(nodo6);
        nodo1.addChild(nodo7);
    }

    private boolean checkAbeto (GeneralTree<Integer>arbolActual){
        int cantHijosHojas=0; boolean soy = false; boolean esHijoAbeto = true;
        for (GeneralTree<Integer>child: arbolActual.getChildren()){
            if(child.isLeaf()){
                cantHijosHojas++;
            }
            else {
                esHijoAbeto = checkAbeto(child);
            }
        }
        if (cantHijosHojas >= 3){
            soy = true;
        }
        return soy && esHijoAbeto;
    }


    public String esAbeto(){
        if (this.checkAbeto(this.arbol)){
            return "es abeto";
        }
        return "no es abeto";
    }

    public static void main (String[]args){
        Navidad n = new Navidad();
        System.out.println(n.esAbeto());
    }
}
