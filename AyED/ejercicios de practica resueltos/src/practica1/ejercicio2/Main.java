package practica1.ejercicio2;
import java.util.Scanner;
public class Main {
    private static int [] vector;
    private static int [] vectorCreado;

    public static int[] crearVector (int n){
        vector  = new int [n];
        for (int i=0; i<n; i++){
            vector [i] = n*i;
        }
        return vector ;
    }
    public static void main (String [] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        vectorCreado =  crearVector(n);
        for (int j = 0; j < n; j++){
            System.out.println("posicion: "+ (j+1) + " = " + vectorCreado[j] + "\n");

        }
    }


}
