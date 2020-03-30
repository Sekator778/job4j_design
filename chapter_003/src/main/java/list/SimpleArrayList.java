package list;

import java.util.*;

/**
 * @author Sekator  : mail sekator778@gmail.com
 *
 * динамический контейнер
 * Итератор должен реализовывать fail-fast поведение, т.е. если с момента создания итератора
 * коллекция подверглась структурному изменению, итератор должен кидать ConcurrentModificationException.
 * Это достигается через введение счетчика изменений - modCount.
 * Каждая операция, которая структурно модифицирует коллекцию должна инкрементировать этот счетчик.
 * В свою очередь итератор запоминает значение этого счетчика на момент своего создания (expectedModCount),
 * а затем на каждой итерации сравнивает сохраненное значение,
 * с текущим значением поля modCount, если они отличаются, то генерируется исключение.
 */

public class SimpleArrayList<E> implements Iterable<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] container;
    private int size;
    private int modCount = 0;

    public SimpleArrayList() {
        this.container = new Object[DEFAULT_CAPACITY];
    }

    public SimpleArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.container = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.container = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public boolean add(E value) {
        ensureCapacity(size + 1);
        container[size++] = value;
        modCount++;
        return true;
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Illegal index: " + index);
        }
        return (E) container[index];
    }

    private void grow(int newCapacity) {
        container = Arrays.copyOf(container, newCapacity);
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > container.length) {
            int newCapacity = container.length == 0 ? 1 : container.length * 2;
            grow(newCapacity);
        }
    }

    public int length() {
        return this.size;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            joiner.add(container[i].toString());
        }
        return joiner.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleArrayIterator();
    }

    /**
     * внутренняя реализация итератора
     */
    private class SimpleArrayIterator implements Iterator<E> {
        private int index;
        private int currentModCount;

        public SimpleArrayIterator() {
            this.currentModCount = modCount;
        }

        /**
         * @return возможен ли индекс
         */
        @Override
        public boolean hasNext() {
            return index < size;
        }

        /**
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
            return (E) container[index++];
        }
    }
}