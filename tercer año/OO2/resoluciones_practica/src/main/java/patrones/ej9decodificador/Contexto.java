package patrones.ej9decodificador;

import java.util.List;

public abstract class Contexto {
    protected Decodificador decodificador;

    public Contexto(Decodificador decodificador){
        this.decodificador=decodificador;
    }

    public abstract List<Pelicula> sugerencias();


}
