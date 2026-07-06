package parcialesViejos.parcial2.patrones;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Seccion implements Elemento {
    private String titulo;
    private List<Elemento> elementos = new ArrayList<>();

    public Seccion(String titulo,List<Elemento> elementos) {
        this.titulo = titulo;
        this.elementos=elementos;
    }
    @Override
    public String toString(){
        return "### " + this.titulo + "\n" + this.elementos.stream().map(Elemento::toString).collect(Collectors.joining());
    }

    @Override
    public boolean contieneElTexto(String texto) {
        return titulo.contains(texto) || this.elementos.stream().anyMatch(elemento -> elemento.contieneElTexto(texto));
    }

    public void setElementos(List<Elemento> elementos) {
        this.elementos = elementos;
    }

    @Override
    public Elemento traducir() {
        String tituloTraducido = Translator.translate(this.titulo);
        List<Elemento> elementosTraducidos = this.elementos.stream().map(elemento -> elemento.traducir()).collect(Collectors.toList());
        Elemento seccionTraducida = new Seccion(tituloTraducido,elementosTraducidos);
        return seccionTraducida;
    }
}
