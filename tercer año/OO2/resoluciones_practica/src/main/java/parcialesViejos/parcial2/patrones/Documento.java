package parcialesViejos.parcial2.patrones;


public class Documento {
    private String titulo;
    private String autor;
    private Elemento seccionRaiz;

    public Documento(String titulo, String autor, Elemento seccionRaiz) {
        this.titulo = titulo;
        this.autor = autor;
        this.seccionRaiz = seccionRaiz;
    }

    public boolean buscar (String texto){
        return this.seccionRaiz.contieneElTexto(texto);
    }

    public Documento traducir(){
        String tituloTraducido = Translator.translate(this.titulo);
        Elemento seccionTraducida = this.seccionRaiz.traducir();
        return new Documento(tituloTraducido,this.autor,seccionTraducida);
    }

    @Override
    public String toString() {
        return this.titulo + " - " + this.autor + "\n" + this.seccionRaiz.toString();
    }
}
