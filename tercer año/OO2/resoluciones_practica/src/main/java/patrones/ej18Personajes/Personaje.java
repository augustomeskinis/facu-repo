package patrones.ej18Personajes;

import java.util.LinkedList;
import java.util.List;

public class Personaje {
    private String nombre;
    private int vida;
    private Arma arma;
    private Armadura armadura;
    private List<Habilidad> habilidades;

    public Personaje(String nombre, Arma arma, Armadura armadura){
        this.nombre=nombre;
        this.vida=100;
        this.arma=arma;
        this.armadura=armadura;
        this.habilidades=new LinkedList<>();
    }



    public void addHabilidad(Habilidad habilidad){
        this.habilidades.add(habilidad);
    }

    public Armadura getArmadura() {
        return armadura;
    }

    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
