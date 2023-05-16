package _08_LinkedListDeque;

import interface_form.Queue;

import java.util.NoSuchElementException;

public class MyLinkedDeque<E> implements Queue<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedDeque() {
        head = null;
        tail = null;
        size = 0;
    }

    //offer offerLast offerFirst
    public boolean offerLast(E element) {
        if (size == 0) {
            offerFirst(element);
        }

        Node<E> node = new Node<>(element);

        node.prev = tail;
        tail.next = node;
        tail = node;
        size++;

        return true;
    }

    public boolean offer(E element) {
        offerLast(element);
        return true;
    }

    public void offerFirst(E element) {
        Node<E> node = new Node<>(element);

        // size 가 0인경우
        if (size == 0) {
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

    // 전방 삭제
    // poll pollFirst remove removeFirst
    public E pollFirst() {
        if (head == null) {
            return null;
        }
        Node<E> removed = head;
        E data = removed.data;

        Node<E> next_node = head.next;

        head.next = null;
        head.data = null;

        // 다음 노드가 있을경우
        if (next_node != null) {
            next_node.prev = null;
        }

        // next_node가 null이면 head = null 이 들어간다.
        head = next_node;

        size--;

        //
        if (size == 0) {
            tail = null;
        }
        return data;
    }

    public E poll() {
        return pollFirst();
    }
    public E remove() {
        return removeFirst();
    }
    public E removeFirst() {
        E element = poll();

        if(element == null) {
            throw new NoSuchElementException();
        }
        return element;
    }

    // 후방삭제
    // pollLast
    public E pollLast(){
        if(size == 0){
            return null;
        }

        E data = tail.data;

        Node<E> prev = tail.prev;
        tail.data = null;
        tail.prev = null;

        if(prev != null){
            prev.next = null;
        }

        tail = null;
        tail = prev;
        size --;

        if(size == 0){
            head = null;
        }
        return data;
    }

    public E removeLast() {
        E element = pollLast();

        if(element == null) {
            throw new NoSuchElementException();
        }
        return element;
    }

    public E peekFirst() {
        // 요소가 없을 경우 null 반환
        if(size == 0) {
            return null;
        }

        return head.data;
    }

    public E peek() {
        return peekFirst();
    }

    public E peekLast() {
        // 요소가 없을 경우 null 반환
        if(size == 0) {
            return null;
        }

        return tail.data;
    }

    public E element() {
        return getFirst();
    }

    public E getFirst() {
        E data = peek();

        if(data == null) {
            throw new NoSuchElementException();
        }
        return data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object value) {
        for(Node<E> x = head; x != null; x = x.next) {
            if(value.equals(x.data)) {
                return true;
            }
        }
        return false;
    }
    public void clear() {
        for (Node<E> x = head; x != null;) {
            Node<E> next = x.next;
            x.data = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        size = 0;
        head = tail = null;
    }
}
