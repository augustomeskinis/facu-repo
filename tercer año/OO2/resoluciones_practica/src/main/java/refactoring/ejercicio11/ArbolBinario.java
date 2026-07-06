package refactoring.ejercicio11;

public class ArbolBinario implements Arbol {

    private int valor;
    private Arbol hijoIzquierdo;
    private Arbol hijoDerecho;

    public ArbolBinario(int valor) {
        this.valor = valor;
        // Paso 4: inicializamos lo antes posible con el Null Object,
        // asi nunca hay un null que chequear.
        this.hijoIzquierdo = new ArbolNulo();
        this.hijoDerecho = new ArbolNulo();
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Arbol getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(Arbol hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public Arbol getHijoDerecho() {
        return hijoDerecho;
    }

    public void setDerecha(Arbol hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    @Override
    public String recorrerPreorden() {
        return valor + " - "
                + hijoIzquierdo.recorrerPreorden()
                + hijoDerecho.recorrerPreorden();
    }

    @Override
    public String recorrerInorden() {
        return hijoIzquierdo.recorrerInorden()
                + valor + " - "
                + hijoDerecho.recorrerInorden();
    }

    @Override
    public String recorrerPostorden() {
        return hijoIzquierdo.recorrerPostorden()
                + hijoDerecho.recorrerPostorden()
                + valor + " - ";
    }
}

