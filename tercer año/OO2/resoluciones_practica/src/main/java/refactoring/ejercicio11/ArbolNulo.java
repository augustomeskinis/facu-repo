package refactoring.ejercicio11;
/**
        * Null Object: representa la ausencia de un hijo.
        * Comparte la interfaz Arbol pero "no hace nada":
        * en cualquier recorrido aporta la cadena vacia.
 *
         * Encapsula la decision de como "no hacer nada" y se la
 * oculta al ArbolBinario, que ya no necesita preguntar por null.
        */

public class ArbolNulo implements Arbol {

    @Override
    public String recorrerPreorden() {
        return "";
    }

    @Override
    public String recorrerInorden() {
        return "";
    }

    @Override
    public String recorrerPostorden() {
        return "";
    }
}
