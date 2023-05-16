package _04_Stack;

import interface_form.StackInterface;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyStack<E> implements StackInterface<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int capacity;
    private int tos;

    public MyStack(){
        array = new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        tos = -1;
    }

    public MyStack(int capacity){
        array = new Object[capacity];
        this.capacity = capacity;
        tos = -1;
    }

    //resize해야할 상황
    //capacity 10 element 3 절반
    // 부족할때 capacity 10 element 10
    public void resize(){
        int size = tos+1; // 요소의 수


        // 부족
        if(capacity == size){
            capacity = capacity * 2;
            array = Arrays.copyOf(array, capacity);
            return;
        }

        // 여유
        if(size < capacity /2){
            array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, capacity/2));
            capacity = array.length;
            return;
        }


    }

    //
    @Override
    public E push(E item) {
        resize();

        array[++tos] = item;
        return item;
    }

    @Override
    public E pop() {
        if(tos == -1){
            throw new NoSuchElementException();
        }
        // E o = (E) array[tos--];
        @SuppressWarnings("unchecked")
        E data = (E) array[tos];
        array[tos] = null;
        tos--;
        resize();
        return data;
    }

    @Override
    public E peek() {
        if(tos == -1){
            throw new NoSuchElementException();
        }
        return (E)array[tos];
    }


    // 위에서부터 찾는겨
    @Override
    public int search(Object o) {
        if(tos == -1){
            throw new NoSuchElementException();
        }

        int index = tos;
        int count = 1;

        for(int i = tos; i > -1; i--){
            if(o.equals(array[i])){
                return count;
            }
            count++;
        }

        return -1;

    }

    @Override
    public boolean empty() {
        return tos == -1;
    }

    @Override
    public int size() {
        return tos + 1;
    }

    @Override
    public void clear() {
        while(tos != -1){
            array[tos--] = null;
        }
        resize();
    }
}
