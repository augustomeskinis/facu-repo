package patrones.ej19fileManager;

import java.time.LocalDate;

public class FileOO2 implements File {
    private String nombre;
    private String extension;
    private long tamanio;
    private LocalDate fechaCreacion;
    private LocalDate fechaModificacion;
    private String permisos;

    public FileOO2(String nombre, String extension, long tamanio,
                   LocalDate fechaCreacion, LocalDate fechaModificacion, String permisos) {
        this.nombre = nombre;
        this.extension = extension;
        this.tamanio = tamanio;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.permisos = permisos;
    }

    @Override
    public String prettyPrint() {
        return "";  // El decorator agrega la información
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getExtension() { return extension; }
    public long getTamanio() { return tamanio; }
    public LocalDate getFechaCreacion() { return fechaCreacion; }
    public LocalDate getFechaModificacion() { return fechaModificacion; }
    public String getPermisos() { return permisos; }
}
