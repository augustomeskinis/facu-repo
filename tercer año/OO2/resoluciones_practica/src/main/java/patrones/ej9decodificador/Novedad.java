package patrones.ej9decodificador;

import java.util.List;
import java.util.stream.Collectors;

public class Novedad extends Contexto {

    public Novedad(Decodificador d){
        super(d);
    }

    @Override
    public List<Pelicula> sugerencias() {
        List<Pelicula>peliculas=decodificador.getPeliculas();
        List<Pelicula>peliculasVistas=decodificador.getPeliculasVistas();

        return peliculas.stream()
                .filter(p -> !peliculasVistas.contains(p))
                .sorted((p1, p2) -> p2.getAnio() - p1.getAnio())
                .limit(3)
                .collect(Collectors.toList());
    }
}
