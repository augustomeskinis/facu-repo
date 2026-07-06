package patrones.ej16excursion;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Excursion {
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String puntoEncuentro;
    private int costo;
    private int cupoMaximo;
    private int cupoMinimo;
    private State state;
    private List<Usuario> usuariosInscriptos;


    public Excursion(String nombre, LocalDate fechaInicio, LocalDate fechaFin,
                    String puntoEncuentro, int costo, int cupoMaximo, int cupoMinimo) {
        this.nombre=nombre;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
        this.puntoEncuentro=puntoEncuentro;
        this.costo=costo;
        this.cupoMaximo=cupoMaximo;
        this.cupoMinimo=cupoMinimo;
        this.state= new sinCupoMinimo(this);
        this.usuariosInscriptos=new LinkedList<>();
    }

    public int cantUsuariosInscriptos(){
        return this.usuariosInscriptos.size();
    }

    public String mailsInscriptos(){
        return this.usuariosInscriptos
                .stream()
                .map(Usuario::getEmail)
                .collect(Collectors.joining(", "));
    }

    public void setState(State state){
        this.state=state;
    }

    public void inscribir (Usuario usuario){
        this.state.inscribir(usuario);
    }

    public String obtenerInformacion(){
        return this.state.obtenerInformacion();
    }

    public void addUsuario(Usuario usuario){
        this.usuariosInscriptos.add(usuario);
    }

    public State getState() {
        return state;
    }

    public List<Usuario> getUsuariosInscriptos() {
        return usuariosInscriptos;
    }

    public int getCupoMinimo() {
        return cupoMinimo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public int getCosto() {
        return costo;
    }

    public String getPuntoEncuentro() {
        return puntoEncuentro;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }
}
