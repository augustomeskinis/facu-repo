/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

public abstract class Empleado {
    private String nombre;
    private int sueldoBasico;
    private int antiguedad;
    
    public Empleado (String unNombre, int unSueldoBasico, int unaAntiguedad) {
        setNombre(unNombre);
        setSueldoBasico(unSueldoBasico);
        setAntiguedad(unaAntiguedad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(int sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    public String toString() {
        String aux ="nombre: " + getNombre();
    return aux;
    }
    
    public abstract double calcularEfectividad ();
    
    public double calcularSueldoACobrar(){
        double aux=0; 
        for (int i=0; i<this.getAntiguedad();i++){
            aux += ( this.getSueldoBasico() * 0.10 );
        }
        return aux;
    }
    
    
    
    
}
