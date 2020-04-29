package list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

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

    /**
     * реверс связного списка
     * тут все растянуто для понятности
     * можно оптимизировать
     * меньше строк
     */
    void reverse() {
//        есть ли список
        if (head == null) {
            throw new IllegalArgumentException("empty chain");
        }
        //тут типа для оптимизации мы сразу выходим
        // из метода когда список из 1го елемента
        if (head.next == null) {
            return;
        }
        // делаем 3 нода некст карент и превиос
        Node<T> current = head;
        Node<T> previous = null;
        Node<T> next = head.next;
        // на котором стоим чекаем или он уже не нулл тоесть конец
        while (current != null) {         //next item
            next = current.next;       ///
            current.next = previous;    // ////swap items
            previous = current;       ///

            head = current;              //тут голову делаем на текущий а текущий ниже смотрим двигаем вперед
            current = next;             //тут просто вперед двигаем
        }
    }
    public void reversed() {
        Node<T> current = head;
        Node<T> next = null;
        Node<T> previous = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;

            head = current;
            current = next;
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

    public static void main(String[] args) {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(5);
        System.out.println(linked);
        linked.reversed();
        System.out.println(linked);


    }
}