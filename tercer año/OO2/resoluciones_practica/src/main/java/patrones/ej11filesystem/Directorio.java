package patrones.ej11filesystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Directorio extends Elemento {

    private List<Elemento> elementos;


    public Directorio (String nombre, LocalDate fechaCreacion){
        super(nombre,fechaCreacion);
        this.elementos = new ArrayList<>();
    }

    public int tamaño(){
        return 32 + this.elementos.stream()
                    .mapToInt(el -> el.tamaño())
                    .sum();
    }

    public void addElemento(Elemento elemento){
        this.elementos.add(elemento);
    }

    @Override
    public Archivo archivoMasGrande() {
        return elementos.stream().map(elem -> elem.archivoMasGrande())
                .max((archivo1, archivo2) -> Integer.compare(archivo1.tamaño(), archivo2.tamaño()))
                .orElse(null);
    }

    @Override
    public Archivo archivoMasNuevo() {
        return elementos.stream().map(elem -> elem.archivoMasNuevo())
                .max((archivo1, archivo2) -> archivo1.getFechaCreacion().compareTo(archivo2.getFechaCreacion()))
                .orElse(null);
    }

    @Override
    public Elemento buscar(String nombre) {
        return this.compareName(nombre) ? this :
                this.elementos.stream().map(elem -> elem.buscar(nombre))
                .filter(elemento -> elemento != null).findFirst().orElse(null);
    }


    protected void buscarEnHijos(String nombre, List<Elemento> lista) {
        this.elementos.stream().forEach(elem -> elem.buscarTodos(nombre, lista));
    }

    @Override
    public String listadoDeContenido(String prefijo) {
        StringBuilder resultado = new StringBuilder();
        String pathActual = prefijo + this.getNombre();
        resultado.append(pathActual).append("\n");
        resultado.append(
                elementos.stream()
                        .map(elem -> elem.listadoDeContenido(pathActual + "/"))
                        .collect(Collectors.joining())
        );
        return resultado.toString();
    }
}
