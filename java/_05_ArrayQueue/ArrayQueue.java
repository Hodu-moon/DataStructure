package _05_ArrayQueue;

import interface_form.Queue;

public class ArrayQueue<E> implements Queue<E> {
    private static final int DEFAULT_CAPACITY = 8;	// 최소(기본) 용적 크기

    private Object[] array;	// 요소를 담을 배열
    private int size;	// 요소 개수

    private int front;	// 시작 인덱스를 가리키는 변수(빈 공간임을 유의)
    private int rear;	// 마지막 요소의 인덱스를 가리키는 변수

    private static int s;

    // 생성자1 (초기 용적 할당을 안할 경우)
    public ArrayQueue() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    // 생성자2 (초기 용적 할당을 할 경우)
    public ArrayQueue(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }


    public void resize(int capacity){
        Object[] new_array = new Object[capacity];

//        //  | f |   |   | r |
//        //  | a | b | c | d |
//        if(front < rear){
//            System.out.println("front < rear");
//            for(int i = front + 1; i <= rear ; i++){
//                new_array[i] = array[i];
//            }
//            array = new_array;
//        }
//        //  | 0 | 1 | 2 | 3 | 4 |
//        //  |   | r |   | f |   |
//        //  | a | b |   |   | e |
//        //
//        //   length = 5;
//
//        if(front > rear){
//            System.out.println("front > rear");
//
//            int j = 1;
//            // 뒷부분
//            for(int i = front + 1; i < length; i++, j++){
//                new_array[j] = array[i];
//            }
//            //앞부분
//            for(int i = 0; i <= rear; i++, j++){
//                new_array[j] = array[i];
//            }
//            front = 0;
//            rear = size;
//            array = new_array;
//        }

        for(int i = 1, j = front + 1 ; i <= size; i++, j++){
            new_array[i] = array[ j % array.length ];
        }

        array = new_array;

        front = 0;
        rear = size; // 1부터 채워넣었으니 size와 인덱스는 같다.


    }

    //원형 큐 생각
    @Override
    public boolean offer(E e) {


        //늘리기
        if( (rear + 1) % array.length  == front){
            System.out.println("resize 늘리기 ");
            resize(array.length * 2);
        }

        rear = (rear + 1)  % array.length;
        array[rear] = e;
        size++;
        System.out.println("front: " + front + " rear: " + rear);
        return true;
    }

    @Override
    public E poll() {
        if(size == 0){
            return null;
        }


        front = ( front +1) % array.length;
        E data = (E)array[front];
        array[front] = null;
        size--;

        if(array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {

            // 아무리 작아도 최소용적 미만으로 줄이지는 않도록 한다.
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
            System.out.println("resize 줄이기 ");
        }
        return data;

    }

    @Override
    public E peek() {
        if(size == 0){
            return null;
        }

        return (E)array[front % array.length + 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public boolean contains(Object value) {

        int start = (front + 1) % array.length;


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
