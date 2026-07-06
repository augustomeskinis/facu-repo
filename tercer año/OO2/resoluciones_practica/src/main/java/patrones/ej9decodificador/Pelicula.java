package patrones.ej9decodificador;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
    private String titulo;
    private int anio;
    private double puntaje;
    private List<Pelicula> peliculasSimilares;

    public Pelicula (String titulo, double puntaje, int anio){
        this.peliculasSimilares=new ArrayList<>();
        this.titulo=titulo;
        this.anio=anio;
        this.puntaje=puntaje;
    }

    public void addPeliculaSimilar(Pelicula p){
        this.peliculasSimilares.add(p);
    }

    public List<Pelicula> getPeliculasSimilares(){
        return this.peliculasSimilares;
    }

    public int getAnio() {
        return anio;
    }

    public double getPuntaje(){
        return this.puntaje;
    }
}
