package parcialesViejos.parcial2.patrones;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaOrdenada implements Elemento {
    private List<String> lista = new ArrayList<>();

    public ListaOrdenada(List<String> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < lista.size(); i++) {
            resultado += (i + 1) + ". " + lista.get(i) + "\n";
        }
        return resultado;
    }

    @Override
    public boolean contieneElTexto(String texto) {
        return this.lista.stream().anyMatch(elemento -> elemento.contains(texto));
    }

    @Override
    public Elemento traducir() {
        List<String> listaTraducida = this.lista.stream().map(elemento -> Translator.translate(elemento)).collect(Collectors.toList());
        return new ListaOrdenada(listaTraducida);
    }
}
