package post;

import java.util.AbstractList;

/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class LinkedListPost<T> extends AbstractList<T> {
    private Node<T> head;
    private int size;

    @Override
    public int size() {
        return size();
    }

    @Override
    public boolean add(Object o) {
        Node<T> addNode = new Node<>(o);
        if (head == null) {
            this.head = addNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(addNode);
        }
        size++;
        return true;
    }

    @Override
    public T get(int index) {
        T rsl = null;
        int i = 0;
        Node<T> tmp = head;
        while (tmp != null) {
            if (i == index) {
                rsl = tmp.getValue();
                break;
            } else {
                i++;
                tmp = tmp.getNext();
            }
        }
        return rsl;
    }

    @Override
    public String toString() {
        return "LinkedListPost{" + "head=" + head + ", size=" + size + '}';
    }

    public static void main(String[] args) {
        LinkedListPost<Integer> listPost = new LinkedListPost();
        listPost.add(1);
        listPost.add(2);
        listPost.add(3);
        for (int i = 0; i < listPost.size; i++) {
            System.out.println(listPost.get(i));
        }

    }
}
