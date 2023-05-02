import _01_ArrayList.ArrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[]a = new int[5];
        System.out.println("a.length = " + a.length);
        ArrayList arrayList = new ArrayList(10);
        for (int i = 0; i < 10; i++){
            arrayList.add(i);
        }

        for(int i = 0; i < arrayList.size(); i++){
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println("======= after remove(5) ");

        arrayList.remove(5);
        for(int i = 0; i < arrayList.size(); i++){
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();
    }
}