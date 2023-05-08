package _01_ArrayList;

import interface_form.List;

import java.util.Arrays;

public class MyArrayList<E> implements List<E> {
    static Object[] EMPTY_ARRAY = {};
    static int DEFAULT_CAPACITY = 10;
    Object[] arrayList;
    int size;

    public MyArrayList(){
        arrayList = EMPTY_ARRAY;
        size = 0;
    }
    public MyArrayList(int capacity){
        arrayList = new Object[capacity];
        size = 0;
    }

    private void resize(){
        int array_length = arrayList.length;

        //처음
        if(array_length == 0){
            arrayList = new Object[DEFAULT_CAPACITY];
            return;
        }

        //용량이 부족한 경우 2배 늘려준다.
        if( array_length == size){
            arrayList = Arrays.copyOf(arrayList, array_length * 2);
            return;
        }

        // 용량이 넘치는 경우
        if( array_length/2 > size){
            arrayList = Arrays.copyOf(arrayList, Math.max(DEFAULT_CAPACITY, array_length/2));
            return;
        }
    }

    @Override
    public void add(int index, E element) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        resize();

        for(int i = size-1; i >= index; i--){
            arrayList[i + 1] = arrayList[i];
        }

        arrayList[index] = element;
        size++;

    }

    @Override
    public boolean add(E element) {
        resize();

        arrayList[size] = element;
        size++;

        return true;
    }
    public void addFirst(E value){
        add(0, value);
    }
    public void addLast(E value){
        add(value);
    }

    @Override
    public E get(int index) {
        return (E)arrayList[index];
    }

    @Override
    public E set(int index, E value) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Object o = arrayList[index];

        arrayList[index] = value;

        return (E)o;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) >= 0 ;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;

        for(int i = 0; i < arrayList.length; i++){
            if(arrayList[i].equals(o)){
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Object removed_value = arrayList[index];

        for(int i = index; i < size - 1 ; i++){
            arrayList[i] = arrayList[i + 1];
        }
        return (E)removed_value;
    }

    @Override
    public boolean remove(Object value) {
        int index = indexOf(value);
        if( index > 0 ){
            remove(index);
            return true;
        }
        return false;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for(int i = 0; i < arrayList.length; i++){
            arrayList[i] = null;
        }
        resize();
    }
}
