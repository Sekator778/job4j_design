package list;

/**
 * @author Sekator  : mail sekator778@gmail.com
 */

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public static void main(String[] args) {
        ForwardLinked<Integer> list = new ForwardLinked<>();
        for (int c = 1; c <= 4; c++) {
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

    //idem по списку, первому next указываешь null, а каждому последующему предыдущий
    public void revert() {
        if (head.next == null) {
            return;
        }
        //1 - 2 - 3 - 4
//       Node<T> temp = head.next;            // temp = 2
//        head.next = null;                   // 2 nod = null
//        while (temp != null) {              //
//            Node<T> next = temp.next;       // next = 3
//            temp.next = head.next;          // 3 = 2
//            head.next = temp;               // null = 2
//            temp = next;                    // 2 = 3
//        }
        Node<T> temp = head;
        while (temp.next != null) {
            Node<T> next = temp.next;
            temp.next = next.next;
            next.next = temp;
            Node<T> htemp = head;
            head = next;
            head.next = htemp;
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