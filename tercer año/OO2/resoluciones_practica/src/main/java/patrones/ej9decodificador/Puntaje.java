package patrones.ej9decodificador;

import java.util.List;
import java.util.stream.Collectors;

public class Puntaje extends Contexto{

    public Puntaje (Decodificador d){
        super(d);
    }

    @Override
    public List<Pelicula> sugerencias() {
        List<Pelicula>peliculas=decodificador.getPeliculas();
        List<Pelicula>peliculasVistas=decodificador.getPeliculasVistas();

        return peliculas.stream()
                .filter(p-> !peliculasVistas.contains(p))
                .sorted((p1,p2) -> (int) (p2.getPuntaje() - p1.getPuntaje()))
                .sorted((p1, p2) -> p2.getAnio() - p1.getAnio())
                .collect(Collectors.toList());
    }
}
