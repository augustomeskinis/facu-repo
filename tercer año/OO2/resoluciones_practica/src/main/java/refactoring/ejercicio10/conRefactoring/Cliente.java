package refactoring.ejercicio10.conRefactoring;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
    public List<Llamada> llamadas = new ArrayList<Llamada>();
    private String nombre;
    private String numeroTelefono;

    public Cliente(String nombre, String numeroTelefono) {
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
    }

    public Llamada registrarLlamada(Cliente destino, LLamadaStrategy strategy, int duracion) {
        Llamada llamada = new Llamada(this.numeroTelefono, destino.getNumeroTelefono(), duracion, strategy);
        this.llamadas.add(llamada);
        return llamada;
    }

    public abstract double getDescuento();

    // en Cliente
    public double calcularMontoTotal() {
        return llamadas.stream()
                .mapToDouble(l -> l.getMonto() * (1 - getDescuento()))
                .sum();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNumeroTelefono() {
        return numeroTelefono;
    }
    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

}
