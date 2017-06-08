package collections;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * LinkedList implement
 * Created by davlet on 6/7/17.
 */
public class MyLinkedList<T> {
    private int size = 0;
    Node<T> head;
    Node<T> tail;

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T elem, Node<T> next) {
            this.prev = prev;
            this.value = elem;
            this.next = next;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public void add(T elem) {
        Node<T> l = this.tail;
        Node<T> newNode = new Node<T>(l, elem, null);
        tail = newNode;
        if (l == null) {
            head = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public T add(T elem, int index) {
        Node<T> current = this.head;
        for (int i = 0; i < index; i++)
            current = current.next;
        Node<T> newNode = new Node<T>(null, elem, null);
        current.prev.next = newNode;
        current.prev = newNode;
        newNode.next = current;
        newNode.prev = current.prev;
        size++;
        return elem;
    }

    public T get(int index) {
        Node<T> temp = this.head;
        for (int i = 0; i < index; i++)
            temp = temp.next;
        return temp.value;
    }

    public void remove(int index) {
        if (index >= this.size)
            throw new IndexOutOfBoundsException();
        if (index == 0) {
            if (size == 1) {
                this.head = null;
                this.tail = null;
                size = 0;
                return;
            }
            this.head = head.next;
            this.head.prev = null;
            size--;
            return;
        }

        int counter = 0;
        Node<T> temp = this.head;
        for (int i = 0; i < this.getSize(); i++) {
            if (counter == index) {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            } else {
                temp = temp.next;
                counter++;
            }
        }
        size--;
    }

    public int getSize() {
        return this.size;
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.get(i));
        }
    }

    private ListIterator<T> MyIterator(){
        return new AscendingIterator();
    }

    public class AscendingIterator implements ListIterator<T>{
        private Node<T> next;
        private int nextIndex;

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            next = next.next;
            nextIndex++;
            return next.value;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public T previous() {

            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(T t) {

        }

        @Override
        public void add(T t) {

        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(10000);
        linkedList.add(10001);
        linkedList.add(10002);
        System.out.println(linkedList.size);
        linkedList.print();

        linkedList.remove(0);
        linkedList.print();

        linkedList.add(11111, 1);
        linkedList.print();
        System.out.println(linkedList.size);
    }
}