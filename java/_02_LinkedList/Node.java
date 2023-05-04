package _02_LinkedList;

public class Node <E>{
    E data;
    Node<E> next;

    Node(E data){
        this.data = data;
        this.next = null;
    }
}
