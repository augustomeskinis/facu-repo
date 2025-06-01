/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasando;

/**
 *
 * @author Augusto
 */
public class Auto {
    private String nombreDueño;
    private int patente;
    
    public Auto (String unNombre, int unaPatente){
        this.nombreDueño=unNombre;
        this.patente=unaPatente;
    }

    public String getNombreDueño() {
        return nombreDueño;
    }

    public int getPatente() {
        return patente;
    }
    
    public String toString(){
        String aux = "nombre del dueño " + this.getNombreDueño() + ", patente: " + this.getPatente();
        return aux;
    }
    
}
