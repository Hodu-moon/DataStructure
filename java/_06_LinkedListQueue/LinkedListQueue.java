package _06_LinkedListQueue;

import interface_form.Queue;

public class LinkedListQueue<E> implements Queue {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedListQueue() {
            this.head = null;
            this.tail = null;
            this.size = 0;
    }
    // 뒤에만 추가해주자
    @Override
    public boolean offer(Object o) {
        Node node = new Node(o);

        if(tail != null){
            tail.next = node;
        }

        tail = node;
        if(size == 0){
            head = node;
        }
        size ++;
        return true;
    }
    //Retrieves and removes the head of this queue, or returns null if this queue is empty.
    @Override
    public Object poll() {
        if(isEmpty()){
            return null;
        }

        E data = head.data;
        head = head.next;
        size--;
        return data;
    }

    @Override
    public Object peek() {
        if(isEmpty()){
            return null;
        }
        return head.data;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
