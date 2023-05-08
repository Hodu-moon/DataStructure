import _01_ArrayList.ArrayList;
import _02_LinkedList.MySLinkedList;
import _02_LinkedList.SLinkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MySLinkedList<Integer> integerMySLinkedList = new MySLinkedList<>();
        integerMySLinkedList.addLast(3);
        integerMySLinkedList.addLast(6);
        integerMySLinkedList.addLast(9);
        integerMySLinkedList.remove(0);
        integerMySLinkedList.remove(Integer.valueOf(6));

        integerMySLinkedList.add(33);
        integerMySLinkedList.add(3414);
        integerMySLinkedList.remove(Integer.valueOf(6));





        for(int i = 0; i < integerMySLinkedList.size(); i++){
            System.out.print(integerMySLinkedList.get(i) + " ");
        }

    }
}