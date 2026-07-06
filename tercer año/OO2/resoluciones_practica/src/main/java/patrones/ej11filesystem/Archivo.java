package patrones.ej11filesystem;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Archivo extends Elemento {
    private int bytes;

    public Archivo (String nombre, LocalDate fechaCreacion, int bytes){
        super(nombre,fechaCreacion);
        this.bytes=bytes;
    }

    public int tamaño(){
        return this.bytes;
    }

    @Override
    public Elemento buscar(String nombre) {
        return this.compareName(nombre) ? this : null;
    }

    @Override
    public Archivo archivoMasGrande() {
        return this;
    }

    @Override
    public Archivo archivoMasNuevo() {
        return this;
    }

    protected void buscarEnHijos(String nombre, List<Elemento> lista) {}

    @Override
    public String listadoDeContenido(String prefijo) {
        return prefijo + this.getNombre() + "\n";
    }
}
