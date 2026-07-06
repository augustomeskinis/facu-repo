package patrones.ej16excursion;

public abstract class State {
    protected Excursion excursion;

    public State (Excursion excursion){
        this.excursion=excursion;
    }

    public String obtenerInformacion(){
        return "nombre:" + excursion.getNombre() + " ,costo:" + excursion.getCosto() + ", fechas: " +
                excursion.getFechaInicio() + " , fecha fin:" + excursion.getFechaFin() + " ,punto de encuentro: "
                + excursion.getPuntoEncuentro();
    }
    public abstract void inscribir(Usuario usuario);

}
