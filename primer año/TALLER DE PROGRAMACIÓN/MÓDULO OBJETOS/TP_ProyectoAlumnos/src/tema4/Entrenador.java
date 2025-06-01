/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

public class Entrenador extends Empleado {
    private int campeonatosGanados;
    
    public Entrenador(String unNombre, int unSueldoBasico, int unaAntiguedad,
                        int unosCampeonadosGanados) {
    super(unNombre, unSueldoBasico, unaAntiguedad);
    setCampeonatosGanados(campeonatosGanados);
}

    public int getCampeonatosGanados() {
        return campeonatosGanados;
    }

    public void setCampeonatosGanados(int campeonatosGanados) {
        this.campeonatosGanados = campeonatosGanados;
    }

    public double calcularEfectividad (){
        double aux = (this.getCampeonatosGanados()*100) / this.getAntiguedad();
        return aux;
    }
    
    public double calcularSueldoACobrar(){
        double aux = super.calcularSueldoACobrar();
        if ((this.getCampeonatosGanados()>= 1) && (this.getCampeonatosGanados() <= 4)) {
            aux += 5000;
        }
        else if ((this.getCampeonatosGanados() >= 5) && (this.getCampeonatosGanados() <= 10)) {
            aux += 30000;
        }
        else if (this.getCampeonatosGanados()>10){
            aux += 50000;
        }
        return aux;
    }

    public String toString (){
        String aux = super.toString() + " efectividad del entrenador " + this.calcularEfectividad()
                + " sueldo a cobrar " + this.calcularSueldoACobrar();
        return aux;
    }
    
    
}
