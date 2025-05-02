package practica1.ejercicio7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TestArrayList {
    public static void main (String [] args){
        Scanner s = new Scanner(System.in);
        int num1 = s.nextInt();
        int num2 = s.nextInt();
        int num3 = s.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(num1);linkedList.add(num2);linkedList.add(num3);
        arrayList.add(num1);arrayList.add(num2);arrayList.add(num3);
        for (int i=0;i<3;i++){
            System.out.println(arrayList.get(i));
            System.out.println(linkedList.get(i));
        }
    }
}
// B: no encuentro diferencias
// C: streams, forEach