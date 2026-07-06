package patrones.ej11filesystem;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public abstract class Elemento {
    protected String nombre;
    protected LocalDate fechaCreacion;

    public Elemento(String nombre, LocalDate fechaCreacion){
        this.nombre=nombre;
        this.fechaCreacion = fechaCreacion;
    }


    public boolean compareName(String nombre) {
        return this.nombre.equals(nombre);
    }

    public void buscarTodos(String nombre, List<Elemento> lista) {
        if (this.compareName(nombre)) lista.add(this);
        this.buscarEnHijos(nombre, lista);
    }
    protected abstract void buscarEnHijos(String nombre, List<Elemento> lista);

    public abstract Elemento buscar(String nombre);

    public abstract Archivo archivoMasGrande();

    public abstract Archivo archivoMasNuevo();

    public abstract int tamaño();

    public abstract String listadoDeContenido(String prefijo);

    public String getNombre (){
        return this.nombre;
    }

    public LocalDate getFechaCreacion (){
        return this.fechaCreacion;
    }


}
