package practica1.ejercicio1;

public class Main {
    public static void metodo1 (int a, int b){
        for (int i=a+1; i<b; i++ ){
            System.out.println(i + "\n");
        }
    }
    public static void metodo2 (int a, int b){
        int i = a+1;
        while (i<b){
            System.out.println(i);
            i++;
        }
    }

    public static void main(String[] args) {
        metodo1(1,10);
        metodo1(1,10);
    }
}

