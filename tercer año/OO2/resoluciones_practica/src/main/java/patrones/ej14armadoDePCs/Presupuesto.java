package patrones.ej14armadoDePCs;

import java.util.LinkedList;
import java.util.List;

public class Presupuesto {
    private Componente procesador;
    private Componente RAM;
    private Componente disco;
    private Componente gabinete;
    private Componente tarjetaGrafica;
    private List<Componente> componentes;

    public Presupuesto (){
        this.componentes = new LinkedList<>();
    }

    public void addComponente(Componente c){
        this.componentes.add(c);
    }

    public void setTarjetaGrafica(Componente tarjetaGrafica) {
        this.tarjetaGrafica = tarjetaGrafica;
        this.addComponente(tarjetaGrafica);
    }

    public void setGabinete(Componente gabinete) {
        this.gabinete = gabinete;
        this.addComponente(gabinete);
    }

    public void setDisco(Componente disco) {
        this.disco = disco;
        this.addComponente(disco);
    }

    public void setRAM(Componente RAM) {
        this.RAM = RAM;
        this.addComponente(RAM);
    }

    public void setProcesador(Componente procesador) {
        this.procesador = procesador;
        this.addComponente(procesador);
    }

    public double calcularConsumo(){
        return this.componentes.stream().mapToDouble(componente -> componente.getConsumo()).sum();
    }

    public double precio (){
        return this.calcularConsumo()*1.21;
    }

}
