import _01_ArrayList.ArrayList;
import _02_LinkedList.SLinkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SLinkedList<Integer> integerSLinkedList = new SLinkedList<>();
        for(int i = 0; i < 30; i++){
            integerSLinkedList.add(i);
        }

        System.out.println("integerSLinkedList = " + integerSLinkedList);

        for(int i = 0; i <integerSLinkedList.size(); i++){
            System.out.print(integerSLinkedList.get(i) + " ");
        }
        System.out.println();
        System.out.println(integerSLinkedList.size() + " ");


        integerSLinkedList.remove(10);

        System.out.println("integerSLinkedList = " + integerSLinkedList);


        System.out.println("=======================");

        for(int i = 0; i <integerSLinkedList.size(); i++){
            System.out.print(integerSLinkedList.get(i) + " ");
        }
        System.out.println();
        System.out.println(integerSLinkedList.size() + " ");


        integerSLinkedList.add(10, 100);
        for(int i = 0; i <integerSLinkedList.size(); i++){
            System.out.print(integerSLinkedList.get(i) + " ");
        }
        System.out.println();
        System.out.println(integerSLinkedList.size() + " ");


    }
}