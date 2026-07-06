package refactoring.ejercicio11;

/**
 * Interfaz que comparten tanto el nodo real (ArbolBinario)
 * como el Null Object (ArbolNulo). Define únicamente el
 * comportamiento que el cliente necesita delegar a un colaborador:
 * los tres recorridos.
 */
public interface Arbol {

    String recorrerPreorden();

    String recorrerInorden();

    String recorrerPostorden();
}
