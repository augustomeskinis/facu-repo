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
public class Estacionamiento {
    private String nombre;
    private String direccion;
    private double horaApertura;
    private double horaCierre;
    private int N;
    private int M;
    private Auto matriz [] [];  // java inicializa en null
    
    public Estacionamiento (String unNombre, String unaDireccion){
        this.nombre=unNombre;
        this.direccion=unaDireccion;
        this.horaApertura=8.00;
        this.horaCierre=21.00;
        N=5;
        M=10;
        matriz = new Auto[N][M];
    }
    
    public Estacionamiento (String unNombre, String unaDireccion, double unaHoraApertura,
                            double unaHoraCierre, int unN, int unM){
    this.nombre=unNombre;
    this.direccion=unaDireccion;
    this.horaApertura=unaHoraApertura;
    this.horaCierre=unaHoraCierre;
    this.N=unN;
    this.M=unM;
    matriz = new Auto[N][M];
    }
    
    public void agregarAuto(Auto A, int X, int Y){
        matriz[X-1][Y-1]=A;
    }
    
    public String dondeEsta(int unaPatente){
        int i=0; int j=0; boolean encontre=false;
        String aux="";
        while ((i<N) && (encontre == false)) {
            j=0;
            while ((j<M) && (encontre==false)) {
                if ((matriz[i][j] != null) &&(matriz[i][j].getPatente()==unaPatente)){
                    encontre=true;
                }
                else {
                    j++;
                }
            }
            i++;
        }
        
        if (encontre == true){
            aux = "Piso: " + i + " plaza: " + (j+1);
        }
        else {
                aux = "Auto inexistente.";
        }
        return aux;
    }
    
    public String toString(){
        String aux="";
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                aux+= "Piso: " + (i+1) + " plaza: " + (j+1) + ": ";
                if (matriz[i][j]==null){
                    aux+= ": libre. " + "\n";
                }
                else
                    aux+= matriz[i][j].toString() + "\n";
            }
        }
        return aux;
    }
    
    public int getCantidad (int Y){
        int cant=0;
        for (int i=0; i<N; i++)
            if (matriz[i][Y-1] != null){
                cant++;
            }
        return cant;
    }

    
    
}
