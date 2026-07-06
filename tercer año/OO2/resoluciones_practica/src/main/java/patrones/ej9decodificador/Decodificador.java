package patrones.ej9decodificador;

import java.util.ArrayList;
import java.util.List;

public class Decodificador {
    private List<Pelicula> peliculas;
    private List<Pelicula> peliculasVistas;
    private Contexto contexto;

    public Decodificador (){
        this.peliculas=new ArrayList<>();
        this.peliculasVistas=new ArrayList<>();
    }


    public List<Pelicula> sugerencias (){
        return this.contexto.sugerencias();
    }

    public void cambiarContexto(Contexto c){
        this.contexto=c;
    }


    // adds y getters
    public void addPelicula(Pelicula p){
        this.peliculas.add(p);
    }

    public void addPeliculaVista(Pelicula p){
        this.peliculasVistas.add(p);
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public List<Pelicula> getPeliculasVistas() {
        return peliculasVistas;
    }
}
