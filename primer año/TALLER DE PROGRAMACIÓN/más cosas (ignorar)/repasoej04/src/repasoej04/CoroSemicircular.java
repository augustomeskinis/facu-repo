/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoej04;

public class CoroSemicircular extends Coro {
    private Corista [] vector; // java inicializa en null
    private int dl=0;
    private int df;
    
    public CoroSemicircular(String unNombre, Director unD, int N){
        super(unNombre,unD);
        df=N;
        vector = new Corista [df];
    }
    
    public void agregarCorista (Corista C){
        if (dl<df){
            vector[dl]=C;
            dl++;
        }
    }
    
    public boolean estaLleno(){
        boolean aux=false;
        if (this.dl==this.df){
            aux=true;
        }
        return aux;
    }
    
    public  boolean estaBienFormado(){
        boolean aux=true;
        int i=1;
        int mayorCorista = vector[0].getTonoFundamental();
        
        while((i<this.df)&&(aux==true)){
            if (vector[i].getTonoFundamental()>mayorCorista){
                aux=false;
            }
            i++;
        }
        return aux;
    }
    
    public String toString(){
        String aux = super.toString() + "\n";
        for (int i=0; i<dl; i++){
            aux += vector[i].toString() + "\n";
        }
        return aux;
    }
    
}
