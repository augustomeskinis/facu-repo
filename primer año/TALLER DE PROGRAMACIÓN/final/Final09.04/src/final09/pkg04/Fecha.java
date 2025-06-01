/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final09.pkg04;

/**
 *
 * @author Augusto
 */
public class Fecha {
    private int dia;
    private int mes;
    private int año;
    
    public Fecha (int unDia, int unMes, int unAño){
        this.dia=unDia;
        this.mes=unMes;
        this.año=unAño;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    @Override
    public String toString() {
        return "Fecha{" + "dia=" + dia + ", mes=" + mes + ", a\u00f1o=" + año + '}';
    }
    
    
    
}
