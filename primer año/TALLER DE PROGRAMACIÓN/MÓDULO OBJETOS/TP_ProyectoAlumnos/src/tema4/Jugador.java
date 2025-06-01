/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;


public class Jugador extends Empleado {
    private int partidosJugados;
    private int golesAnotados;
    
    public Jugador (String unNombre, int unSueldoBasico, int unaAntiguedad,
                     int unosPartidosJugados, int unosGolesAnotados) {
        super(unNombre,unSueldoBasico,unaAntiguedad);
        setPartidosJugados(unosPartidosJugados);
        setGolesAnotados(unosGolesAnotados);
        
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }
    
              
                     
    public double calcularEfectividad(){
        double aux = this.getGolesAnotados() / this.getPartidosJugados();
        return aux;
    }
    
    
    public double calcularSueldoACobrar(){
        double aux= super.calcularSueldoACobrar();
        if (this.calcularEfectividad()>0.5){
            aux += this.getSueldoBasico();
        }
        return aux;
    }
    
    public String toString() {
        String aux = super.toString() + " efectividad del jugador: "+this.calcularEfectividad()
                +" sueldo a cobrar + " + this.calcularSueldoACobrar();
        return aux;
}
    

    
}
