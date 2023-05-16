package _05_ArrayQueue;

import interface_form.Queue;

public class MyArrayQueue<E> implements Queue<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;
    private int front;
    private int rear;

    public MyArrayQueue() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    public MyArrayQueue(int capacity) {
        this.array = new Object[Math.max(capacity, DEFAULT_CAPACITY)];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }


    public void resize(int capacity){
        Object[] newArray = new Object[capacity];

        for(int i = 1, j = front + 1; i <= size; i++, j++){
            newArray[i] = array[j % array.length];
        }

        array = newArray;
        front = 0;
        rear = size; // index가 1부터 시작했으므로

    }
    @Override
    public boolean offer(E e) {
        if( (rear + 1) % array.length == front){
            resize(array.length * 2);
        }
        rear = (rear + 1) % array.length;
        array[rear] = e;
        size++;

        return true;
    }


    //꺼낼때 조심할 것은 사이즈가 0일때
    @Override
    public E poll() {
        if(size == 0){
            return null;
        }

        front = (front + 1) % array.length;
        Object data = array[front];
        array[front] = null;

        size--;
        if(array.length >= DEFAULT_CAPACITY && size < array.length / 4){
            resize(Math.max(array.length / 2, DEFAULT_CAPACITY));
        }

        return (E)data;
    }

    @Override
    public E peek() {
        if(size == 0){
            return null;
        }
        return (E)array[(rear + 1) % array.length];
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
