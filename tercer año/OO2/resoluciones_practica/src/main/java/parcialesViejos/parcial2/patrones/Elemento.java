package parcialesViejos.parcial2.patrones;

public interface Elemento {

    @Override
    public String toString();
    public boolean contieneElTexto(String texto);
    public Elemento traducir();
}
