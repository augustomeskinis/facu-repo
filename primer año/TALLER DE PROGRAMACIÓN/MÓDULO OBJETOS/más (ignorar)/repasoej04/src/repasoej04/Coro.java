/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoej04;

public abstract class Coro {
    private String nombre;
    private Director D;
    
    public Coro (String unNombre, Director unD){
        this.nombre=unNombre;
        this.D=unD;
    }
    
    public String toString(){
        String aux = "nombre del coro: " + this.nombre + " ,datos del director: " + this.D.toString();
        return aux;
    }
    
    
    
    public abstract void agregarCorista(Corista C);
    
    public abstract boolean estaLleno();
    
    public abstract boolean estaBienFormado();
    
    
    
    
    
    
    
    
    
    
    
}
