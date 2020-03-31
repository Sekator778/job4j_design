package list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class SimpleLinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private int size;
    private int modCount;

    /**
     * add element to tail list
     *
     * @param value - data for add into Node
     */
    public void add(E value) {
        if (head == null) {
            this.head = new Node<>(value);
        } else {
            Node<E> tmp = head;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(new Node<E>(value));
        }
        modCount++;
        size++;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        Node<E> tmp = head;
        while (tmp.getNext() != null) {
            joiner.add(tmp.data.toString());
            tmp = tmp.getNext();
        }
        joiner.add(tmp.data.toString());
        return joiner.toString();
    }

    /**
     * give first element
     *
     * @return - head of list
     */
    public E get() {
        if (head == null) {
            throw new NoSuchElementException("list empty");
        }
        return head.data;
    }

    /**
     * return element by list index
     *
     * @param index - index for search
     * @return - data
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<E> tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public E deleteLast() {
        return remove(size - 1);
    }

    /**
     * тут надо еще раз все проверить с 0 елементом
     *
     * @param index - индекс елемента на удаление
     * @return - дату удаленного елемента
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<E> rsl = head;
        if (index == 0) {
            head = head.next;
            size--;
            return rsl.data;
        }
        int currentIndex = 0;
        Node<E> temp = head;
        while (temp != null) {
            if (currentIndex == index - 1) {
                rsl = temp.getNext();
                temp.setNext(temp.getNext().getNext());
                size--;
                break;
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        return rsl.data;
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleLinkedListIterator();
    }

    private class SimpleLinkedListIterator implements Iterator<E> {
        private Node<E> node = head;
        private int currentModCount;

        public SimpleLinkedListIterator() {
            this.currentModCount = modCount;
        }

        /**
         * @return есть ли елемент
         */
        @Override
        public boolean hasNext() {
            return node != null;
        }

        /**
         * начинаем от первого и даем некст от первого
         *
         * @return - next element for iteration
         */
        @Override
        public E next() {
            if (modCount != currentModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E value = node.data;
            node = node.next;
            return value;
        }
    }

    private static class Node<E> {
        private final E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
