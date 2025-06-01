/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

public abstract class Sistema {
    private Estacion E;
    private double [][] matriz;
    private int N;
    private int año;
    
    public Sistema (Estacion unE, int unAño, int unN){
        N=unN;
        setE(unE);
        setAño(unAño);
        matriz = new double [N][12];
        for (int i=0; i<N; i++){
            for (int j=0; j<12; j++){
                matriz[i][j]=120.0;
            }
        }
    }

    public void registrarTemperatura (double unaTemperatura, int unAño, int unMes){
        matriz[unAño - this.getAño()] [unMes-1] = unaTemperatura;
    }
    
    public double obtenerTemperatura (int unAño, int unMes){
        double aux = matriz[(this.getAño()+this.getN() - unAño - 1)][unMes-1];
        return aux;
    }
    
    public String mayorTemperatura (){
        double tempMayor = -300; int añoMayor = 0; int mesMayor = 0;
        for (int i = 0;i < N;i++){
            for(int j=0; j <12; j++){
                if (matriz[i][j]>tempMayor){
                    tempMayor=matriz[i][j];
                    añoMayor = this.getAño() + i;
                    mesMayor = j + 1;
                }
            }
        }
        String aux = "MES CON MAYOR TEMEPERATURA " + mesMayor + " AÑO CON MAYOR TEMPERATURA: " + añoMayor;
        return aux;
    }
    
    public String toString () {
        return E.toString();
    }
    
    public double getElemento(int unAño, int unMes){
        return matriz[unAño - this.getAño()][unMes];
    }
    
    
    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public Estacion getE() {
        return E;
    }

    public void setE(Estacion E) {
        this.E = E;
    }

    public int getN() {
        return N;
    }

    
}
