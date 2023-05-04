package _02_LinkedList;

import interface_form.List;

// Singly LinkedList
public class SLinkedList<E> implements List<E> {
    private Node<E> head;	// 노드의 첫 부분
    private Node<E> tail;	// 노드의 마지막 부분
    private int size;	// 요소 개수

    public SLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node<E> search(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node x = head;

        for(int i = 0; i < index; i++){ //0 12
            x = x.next;
        }

        return x;
    }

    @Override
    public void add(int index, E element) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        if(size == 0){
            addFirst(element);
            return;
        }

        if(size  == index){
            addLast(element);
            return;
        }

        Node<E> prev_node = search(index - 1);

        Node node = new Node(element);
        size++;

        node.next = prev_node.next;

        prev_node.next = node;


    }

    @Override
    public boolean add(E element) {
        addLast(element);
        return true;
    }

    public void addLast(E element){
        Node<E> node = new Node<E>(element);

        if(size == 0){
            addFirst(element);
            return;
        }


        tail.next = node;
        tail = node;
        size++;
    }

    public void addFirst(E element){
        Node<E> node = new Node<E>(element);


        node.next = head;
        head = node;
        size++;

        if(head.next == null) {
            tail = head;
        }
    }

    // remove 구현

    public E remove(){
        if(size  < 0){
            throw new IndexOutOfBoundsException();
        }
        E data = head.data;

        head = head.next;
        size--;

        if(size == 0 ){
            tail = null;
        }

        return data;

    }

    @Override
    public E remove(int index) {
        Node<E> prev_node = search(index - 1);

        Node<E> remove_node = prev_node.next;

        prev_node.next = remove_node.next;
        size--;

        return remove_node.data;
    }

    @Override
    public boolean remove(Object value) {
        int index = indexof(value);
        if(index > 0){
            remove(index);
        }

        return false;

    }


    // get set indexof contains

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
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
//        if (index < 0 || index >= size){
//            throw new IndexOutOfBoundsException();
//        }

        Node<E> search_node = search(index);

        return search_node.data;
    }

    @Override
    public E set(int index, E value) {
//        if (index < 0 || index >= size){
//            throw new IndexOutOfBoundsException();
//        }

        Node<E> search_node = search(index);
        E retrun_value = search_node.data;
        search_node.data = value;
        return retrun_value;
    }

    @Override
    public boolean contains(Object value) {
//        for(int i = 0; i < size; i++){
//            Node<E> search = search(i);
//
//            if(search.data == (E)value){
//                return true;
//            }
//        }


        return indexof(value) >= 0 ;
    }

    @Override
    public int indexof(Object o) {

//        for(int i = 0; i < size; i++){
//            Node<E> search = search(i);
//
//            if(search.data == (E)o){
//                return i;
//            }
//        }
        int index = 0;

        for( Node<E> head1 =  head; head1 != null; head1 = head1.next){
            if(head1.data.equals(o)){
                return index;
            }
            index++;
        }
        return -1;
    }
}
