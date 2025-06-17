/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoej04;

/**
 *
 * @author Augusto
 */
public class CoroHileras extends Coro {
    private Corista matriz [][]; // java inicializa en null
    private int auxFilas=0;
    private int filas;
    private int dimL[];
    private int columnas;
    
    public CoroHileras(String unNombre, Director unD, int unasColumnas, int unasFilas){
        super(unNombre,unD);
        this.filas=unasFilas;
        this.columnas=unasColumnas;
        matriz=new Corista[filas][columnas];
        this.dimL = new int [filas];
    }
    
    public void agregarCorista(Corista C){
        if(auxFilas < filas) {
            if(dimL[auxFilas] < columnas){ // pregunta si hay lugar en la columna
                matriz[auxFilas][dimL[auxFilas]]=C; 
                dimL[auxFilas]++;
            }
            else{
                auxFilas++;
                dimL[auxFilas]=0;
                matriz[auxFilas][dimL[auxFilas]] = C;
                dimL[auxFilas]++;
            }
        }
    }
    
   public boolean estaLleno() {
    boolean aux=true;
    int i=0;
    while ((i<this.filas) && (aux==true)){
        if (dimL[i]<this.columnas){
            aux=false;
        }
        i++;
    }
    return aux; 
}

    
    public boolean estaBienFormado(){
        boolean aux=true;
        int mayorCorista = matriz[0][0].getTonoFundamental();
        int i=1;
        while((i<this.filas)&&(aux==true)){
            if(matriz[i][0].getTonoFundamental()>mayorCorista){
                aux=false;
            }
            i++;
        }
        return aux;
    } 
    
    public String toString(){
        String aux = super.toString() +"\n";
        for(int i=0; i<this.filas; i++){   // recorre las filas
            for(int j=0; j<this.dimL[i];j++){  // recorre los elementos de las filas
                aux+=matriz[i][j].toString() + "\n"; // aca entra si la fila tiene elemento
            }                                         //  (si no tiene, no entra por lo tanto no recorre la estructura entera)
    
        }
        return aux;
    }
    
    
    
}
