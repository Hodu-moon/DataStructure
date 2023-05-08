package _02_LinkedList;

import interface_form.List;

public class MySLinkedList<E> implements List<E> {
    Node<E> head;
    Node<E> tail;
    int size;
    public MySLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }


    /**
     *  인덱스에 위치한 Node 반환
     * @param index
     * @return 인덱스에 위치한 Node
     */
    public Node<E> search(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node<E> x = head;

        for(int i = 0; i < index; i++){
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

        if(index == size){
            addLast(element);
            return;
        }
        Node<E> new_Node = new Node<>(element);

        Node<E> prev_node = search(index - 1);

        new_Node.next = prev_node.next;
        prev_node.next = new_Node;
        size++;

    }

    @Override
    public boolean add(E element) {
        addLast(element);
        return true;
    }

    public void addFirst(E element){
        Node<E> new_Node = new Node<>(element);

        new_Node.next = head;
        head = new_Node;

        if(size == 0){
            tail = head;
        }

        size++;
    }
    public void addLast(E element){
        Node<E> new_Node = new Node<>(element);

        if(size == 0){
            addFirst(element);
            return;
        }

        tail.next = new_Node;
        tail = new_Node;

        size++;
    }

    @Override
    public E get(int index) {
        return search(index).data;
    }

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
        if(index == 0){
            return remove();
        }

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> prev_node = search(index - 1);

        Node<E> remove_node = prev_node.next;

        prev_node.next = remove_node.next;

        if(prev_node.next == null) {
            tail = prev_node;
        }
        size--;

        return remove_node.data;
    }

    @Override
    public boolean remove(Object value) {
        int index = indexOf(value);
        if(index >= 0){
            remove(index);
        }

        return false;

    }

    @Override
    public E set(int index, E value) {
        Node<E> search = search(index);
        E data = search.data;
        search.data = value;

        return data;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) > -1;
    }

    @Override
    public int indexOf(Object o) {
        if (size < 0){
            throw new IndexOutOfBoundsException();
        }
        int index = 0;
        for(Node<E> x = head; x.next != null; x = x.next){
            if(o.equals(x.data)){
                return index;
            }
            index++;
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
        head = null;
        tail = null;
        size = 0;
    }
}
