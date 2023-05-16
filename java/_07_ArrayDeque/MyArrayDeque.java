package _07_ArrayDeque;

import interface_form.Queue;

import java.util.NoSuchElementException;

public class MyArrayDeque <E> implements Queue<E> {
    private static int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int front;
    private int rear;
    private int size;
    // offerLast  는 offer
    // offerFirst 첫번째에 넣기
    // pollFirst 마지막에 넣기
    // pollLast remove

    public MyArrayDeque(){
        this.array = new Object[DEFAULT_CAPACITY];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }
    public MyArrayDeque(int capacity) {
        this.array = new Object[Math.max(DEFAULT_CAPACITY, capacity)];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public void resize(int capacity){
        int length = array.length;
        Object[] newArray = new Object[capacity];

        for(int i = 1, j = front + 1; i <= size; i++, j++){
            newArray[i] = array[j % array.length];
        }

        front = 0;
        rear = size;
        array = newArray;
    }

    @Override
    public boolean offer(E e) {
        if((rear + 1) % array.length == front){
            resize(array.length * 2);
        }
        rear = (rear + 1) % array.length;
        array[rear] = e;
        size++;

        return true;
    }
    public boolean offerLast(E e){
        offer(e);
        return true;
    }

    public boolean offerFirst(E e){
        if((front -1 + array.length) % array.length == rear){
            resize(array.length * 2);
        }

        array[front] = e;
        front = (front - 1 + array.length) % array.length;
        size++;

        return true;
    }


    @Override
    public E poll() {
        return pollFirst();
    }

    public E pollFirst(){
        if(size == 0){
            return null;
        }

        front = (front + 1) % array.length;
        E data =(E) array[front];
        array[front]= null;
        size--;

        if(array.length >= DEFAULT_CAPACITY && size < (array.length / 4)){
            resize(array.length/2);
        }

        return data;
    }

    public E pollLast(){
        if(size == 0){
            return null;
        }

        E data = (E)array[rear];
        array[rear] = null;
        rear = (rear - 1 + array.length) % array.length;
        size --;

        return data;
    }



    @Override
    public E peek() {
        return peekFirst();
    }

    public E peekFirst(){
        if(size == 0){
            return null;
        }

        E data = (E)array[(front + 1) % array.length];

        return data;
    }
    public E peekLast() {
        if(size == 0) {
            return null;
        }

        E data = (E) array[(rear)];
        return data;
    }
    public E element() {
        return getFirst();
    }

    public E getFirst() {
        E item = peek();

        if(item == null) {
            throw new NoSuchElementException();
        }
        return item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object value) {

        int start = (front + 1) % array.length;

        /**
         *  i : 요소 개수만큼만 반복한다.
         *  idx : 원소 위치로, 매 회 (idx + 1) % array.length; 의 위치로 갱신
         */
        for(int i = 0, idx = start; i < size; i++, idx = (idx + 1) % array.length) {
            if(array[idx].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {

        for(int i = 0; i < array.length; i++) {
            array[i] = null;
        }

        front = rear = size = 0;
    }
}
