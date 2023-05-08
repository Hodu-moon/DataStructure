package _01_ArrayList;

import interface_form.List;

import java.util.Arrays;

public class ArrayList<E> implements List<E>, Cloneable{
    private static final int DEFAULT_CAPACITY = 10; // 최소 용적 크기
    private static final Object[] EMPTY_ARRAY = {};

    private int size; // element 수

    Object[] array; // element 담을 배열

    // 생성자 1 (초기 공간 할당 X)
    public ArrayList(){
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    // 생성자 2 (초기 공간 할당)
    public ArrayList(int capacity){
        this.array = new Object[capacity];
        this.size = 0;
    }

    private void resize(){
        // 용적
        int array_capacity = array.length;

        // array capacity가 0인경우
        if(Arrays.equals(array, EMPTY_ARRAY)){
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

        // 용량이 꽉 찰 경우
        if(size == array_capacity){
            array = Arrays.copyOf(array, array_capacity * 2);
            return;
        }


        // 용량의 절반 미만으로 element가 차지하고 있을 경우 최적화를 해보자
        if(size < (array_capacity/ 2)){
            array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, array_capacity/2));
            return;
        }
    }

    @Override
    public void add(int index, E element) {
        // 영역을 벗어날 경우 예외 발생
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        //인덱스랑 사이즈와 같다면
        if(index == size){
            addLast(element);
        }
        else{

            // 체크1 꽉차있는지
            if(size == array.length){
                resize();
            }

            //index기준으로 뒤에 있는 요소들 한칸씩 뒤로 밀기.
            for(int i = size; i > index; i--){
                array[i] = array[i-1];
            }

            array[index] = element;
            size++;
        }
    }

    // add 구현
    // list 인터페이스의 add의 의미는 끝에 value를 추가하는 것이다.
    @Override
    public boolean add(E value){
        addLast(value);
        return true;
    }

    @Override
    public E remove(int index) {
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }

        E r = (E) array[index];
        array[index] = null;

        for(int i = index + 1; i < size; i++){
            array[i -1] = array[i];
            array[i] = null;
        }
        size--;
        resize();
        return r;


    }

    @Override
    public boolean remove(Object value) {
        int index = indexOf(value);

        if(index == -1){
            return false;
        }

        remove(index);
        return true;
    }

    @Override
    public E get(int index) {
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }

        return (E) array[index];
    }

    @Override
    public E set(int index, E value) {
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        E rv = get(index);
        array[index] = value;
        return rv;
    }

    @Override
    public boolean contains(Object value) {
        if(indexOf(value) > -1){
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        for(int i = 0; i < size; i++){
            if(array[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    public int lastindexOf(Object value){
        for(int i = size-1; i >=0 ; i--){
            if(array[i].equals(value)){
                return i;
            }
        }
        return -1;
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
        for(int i = 0; i < size; i++){
            array[i] = null;
        }
        size = 0;
        resize();
    }

    ;

    public void addLast(E value){
        if(size == array.length){
            resize();
        }

        array[size++] = value;
        // 넣고 올린다.
    }

    public void addFirst(E value){
        add(0, value);
    }

    // 부가 clone  Question
    public Object clone() throws CloneNotSupportedException{
        ArrayList<?> cloneList = (ArrayList<?>) super.clone();

        cloneList.array = new Object[size];

        System.arraycopy(array, 0, cloneList, 0, size);

        return cloneList;

    }

    public Object[] toArray(){
        return Arrays.copyOf(array, size);
    }

    public <T> T[] toArray(T[] a){
        if(a.length < size){
            return (T[]) Arrays.copyOf(array,size, a.getClass());
        }
        System.arraycopy(array, 0, a, 0, size);
        return a;
    }
}
