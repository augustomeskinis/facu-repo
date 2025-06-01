/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

public class SistemaAños extends Sistema {
    private double vectorAños [];
    
    public SistemaAños (Estacion unE, int unAño, int unN){
        super(unE,unAño,unN);
        vectorAños = new double [this.getN()];
    }
    
    private void guardarPromedios (){
        double suma=0;
        for (int i=0; i<this.getN();i++){
            suma=0;
            for (int j=0;j<12;j++){
                suma += this.getElemento(this.getAño()+1, j);
            }
            vectorAños[i]=suma/12;
        }
    }
    
    public String toString(){
        this.guardarPromedios();
        String aux = super.toString() + "\n";
        for (int i = 0; i< this.getN(); i++){
            aux += "Año " + (this.getAño()+i) +" " + vectorAños[i] +"\n";
        }
        
        return aux;
    }   
}