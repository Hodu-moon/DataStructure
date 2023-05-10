import _01_ArrayList.ArrayList;
import _02_LinkedList.MySLinkedList;
import _02_LinkedList.SLinkedList;
import _03_DoublyLinkedList.MyDLinkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyDLinkedList<Integer> list = new MyDLinkedList<>();
        list.add(100);
        list.remove(Integer.valueOf(100));
        list.add(344);
        list.add(0, 44);
        list.add(2, 44);
        list.remove();
        list.remove(1);

        for(int i = 0; i < list.size(); i++){
            System.out.print( list.get(i) + " ");
        }
        System.out.println();
    }
}