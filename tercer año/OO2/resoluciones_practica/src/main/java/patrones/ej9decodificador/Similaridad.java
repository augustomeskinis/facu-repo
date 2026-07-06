package patrones.ej9decodificador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Similaridad extends Contexto {

    public Similaridad(Decodificador d){
        super(d);
    }

    @Override
    public List<Pelicula> sugerencias() {
        List<Pelicula> peliculasVistas = this.decodificador.getPeliculasVistas();

        return peliculasVistas.stream()
                .flatMap(p -> p.getPeliculasSimilares().stream())
                .distinct()
                .filter(p -> !peliculasVistas.contains(p))
                .sorted((p1, p2) -> p2.getAnio() - p1.getAnio())
                .limit(3)
                .collect(Collectors.toList());
    }

}
