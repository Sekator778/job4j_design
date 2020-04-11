package list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public static void main(String[] args) {
        ForwardLinked<Integer> list = new ForwardLinked<>();
        for (int c = 1; c <= 3; c++) {
            list.add(c);
        }

        System.out.println(list.toString());
        list.revert();
        System.out.println(list.toString());


    }

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    void revert() {
        if (head.next == null) {
            return;
        }
        Node<T> node = head;
        Node<T> previous = null;
        while (node != null) {         //next item
            Node<T> tmp = node.next;      //swap items
            node.next = previous;
            previous = node;
            head = node;              //next item
            node = tmp;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public Node<T> getNext() {
            return next;
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        Node<T> tmp = head;
        while (tmp.getNext() != null) {
            joiner.add(tmp.value.toString());
            tmp = tmp.getNext();
        }
        joiner.add(tmp.value.toString());
        return joiner.toString();
    }
}