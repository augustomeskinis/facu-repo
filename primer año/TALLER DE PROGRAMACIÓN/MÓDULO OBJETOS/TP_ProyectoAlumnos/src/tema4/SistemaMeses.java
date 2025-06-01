/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

public class SistemaMeses extends Sistema {
    private double vectorMeses[]=new double [12];
    
    public SistemaMeses (Estacion unE, int unAño, int unN){
        super(unE,unAño,unN);
    }
    
    private void guardarPromedios(){
       int suma=0;
       for(int j=0; j<12;j++){
           suma=0;
           for(int i =0; i<this.getN();i++){
               suma+= this.getElemento(this.getAño()+i, j);
           }
           vectorMeses[j]=suma/3;
       }
       
    }
    public String toString (){
        this.guardarPromedios();
        String aux = super.toString() + "\n" ;
        for (int j=0; j<12;j++){
            aux+= "Mes numero " + (j+1) + ": " + vectorMeses[j] + " °C" + "\n";

         }
        return aux;
    }
 
}
