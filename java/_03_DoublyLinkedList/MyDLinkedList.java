package _03_DoublyLinkedList;

import interface_form.List;

public class MyDLinkedList<E> implements List<E> {

    private Node<E> head; // 노드의
    private Node<E> tail;



    private int size;

    public MyDLinkedList(){
        head = null;
        tail = null;
        this.size = 0;
    }

    private Node<E> search(int index){

        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node<E> x;
        if( index + 1 < size/2 ){
            x = head;
            for(int i = 0; i < index; i++){
                x = x.next;
            }
        }else { // index + 1 > size/2  절반 이상에 있을경우
            x = tail;
            for(int i = size -1; i > index; i--){
                x = x.prev;
            }
        }
        return x;
    }

    @Override
    public void add(int index, E element) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        // 처음에 넣는거
        if(index == 0){
            addFirst(element);
            return;
        }

        // 마지막에 넣는거
        if(index == size){
            addLast(element);
            return;
        }

        Node<E> node = new Node<>(element);

        // 중간에 추가하는것
        Node<E> search = search(index - 1);

        node.next = search.next;
        search.next = node;
        node.next.prev = node;
        node.prev = search;
        size++;
    }

    @Override
    public boolean add(E element) {
        addLast(element);
        return true;
    }

    // 첫번째 자리에 요소 집어넣기
    public void addFirst(E element){
        Node<E> node = new Node<>(element);

        // size 가 0인경우
        if(size == 0){
            head = tail = node;
            size++;
            return;
        }

        // size > 0 인경우
        head.prev = node;
        node.next = head;
        head = node;
        size++;
    }

    public void addLast(E element){
        Node<E> node = new Node<>(element);

        // size 가 0인경우
        if(size == 0){
            head = tail = node;
            size++;
            return;
        }
        // size > 0 인경우

        node.prev = tail;
        tail.next = node;
        tail = node;
        size++;
    }

    @Override
    public E get(int index) {
        return search(index).data;
    }

    @Override
    public E set(int index, E value) {
        E data = search(index).data;
        search(index).data = value;
        return data;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> x = head;
        int index = 0;
        for(int i = 0; x != null; x = x.next){
            if(o.equals(x.data)){
                return index;
            }
            index ++;
        }
        return -1;
    }

    // 처음꺼 삭제
    public E remove(){
        if(size <= 0){
            throw new IndexOutOfBoundsException();
        }


        Node<E> removed = head;

        // 개수가 1개이다.
        if(head.next != null){
            head.next.prev = null;
        }

        head = head.next;

        removed.next = null;

        size --;

        if(size == 0){
            tail = null;
        }

        return removed.data;

    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        //처음 삭제
        if(index == 0){
            return remove();
        }
        //마지막 삭제
        if(index == size - 1){
            Node<E> removed = tail;
            tail = tail.prev;

            removed.prev = null;
            removed.next = null;

            tail.next = null;
            size--;
            return removed.data;
        }

        // 중간 삭제
        Node<E> search = search(index - 1);
        Node<E> removed = search.next;
        search.next = removed.next;
        search.next.prev = search;
        size--;

        return removed.data;

    }

    @Override
    public boolean remove(Object value) {
        int i = indexOf(value);
        if (i < 0){
            return false;
        }
        remove(i);
        return true;
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
        head = tail = null;
        size = 0;

    }
}
