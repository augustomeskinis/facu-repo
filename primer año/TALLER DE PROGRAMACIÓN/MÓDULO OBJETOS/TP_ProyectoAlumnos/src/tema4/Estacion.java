/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Augusto
 */
public class Estacion {
    private String nombre;
    private double latitud;
    private double longitud;

    
    public Estacion (String unNombre, double unaLatitud, double unaLongitud){
        setNombre(unNombre);
        setLatitud(unaLatitud);
        setLongitud(unaLongitud);
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    
    public String toString (){
        String aux =  this.getNombre() + "(" 
                + this.getLatitud()+ ")"+ "(" + this.getLongitud() +")";
        return aux;
    }
    

    
}
