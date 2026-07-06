package parcialesViejos.parcial2.patrones;


public class Parrafo implements Elemento {
    private String texto;

    public Parrafo(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString(){
        return this.texto + "\n";
    }

    @Override
    public boolean contieneElTexto(String texto) {
        return this.texto.contains(texto);
    }

    @Override
    public Elemento traducir() {
        return new Parrafo(Translator.translate(this.texto));
    }

}
