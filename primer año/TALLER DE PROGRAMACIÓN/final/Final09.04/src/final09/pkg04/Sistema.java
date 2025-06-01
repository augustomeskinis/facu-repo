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
public class Sistema {
    private int df = 200;
    private int dc = 10;
    private int vectorDL [] = new int [df];
    private Poliza matriz [][] = new Poliza [df][dc];
    
    public void agregarPoliza(Poliza P, int unRubro){
        if (vectorDL[unRubro]<df) {
            matriz[vectorDL[unRubro]][unRubro]=P;
            vectorDL[unRubro]++;
        }
    }
    
    public String infoCliente (int unDNI){
        int i=0; int j; String aux="";
        for (j=0; j<dc; j++) {
            while (i < vectorDL[j]) {
                if (matriz[i][j].getDNI()==unDNI) {
                    aux += matriz[i][j].toString() + "\n";
                }
            i++;
        }
            i=0;
    }
        return aux;
    }
    public void aumentarCuotas(double unPorcentaje, int unRubro){
        int i=0;
        while (i < vectorDL[unRubro]){
            matriz[i][unRubro].setValorCuota(unPorcentaje);
            i++;
        }   
    }
    
    public int cantidadAVencer (int mes, int año){
        int aux=0;
        for(int j=0;j<dc;j++){
            for(int i=0; i<vectorDL[j]; i++){
                if ((matriz[i][j].getFinCobertura().getMes()==mes)&&(matriz[i][j].getFinCobertura().getAño() == año)) {
                    aux++;
            }
            }
        }
        return aux;
    }
    
}
