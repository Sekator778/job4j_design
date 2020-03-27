package generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Sekator
 * this универсальная обертка над массивом
 */
public class SimpleArray<T> implements Iterable<T> {
    private final T[] objects;
    private int size = 0;

    public SimpleArray(int size) {
        this.objects = (T[]) new Object[size];
    }

    /**
     * - добавляет указанный элемент (model) в первую свободную ячейку;
     *
     * @param model - элемент
     */
    public void add(T model) {
        if (size == objects.length) {
            throw new IllegalStateException("Array is full");
        }
        this.objects[size++] = model;
    }

    /**
     * заменяет указанным элементом (model) элемент, находящийся по индексу index;
     *
     * @param index куда вставлять
     * @param model вставляемый елемент
     */
    public void set(int index, T model) {
        checkIndex(index);
        this.objects[index] = model;
    }

    /**
     * удаляет элемент по указанному индексу, все находящиеся справа элементы
     * при этом необходимо сдвинуть на единицу влево (в середине массива не должно быть пустых ячеек);
     *
     * @param index - в каком месте удалять
     */
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < objects.length - 1; i++) {
            this.objects[i] = this.objects[i + 1];
        }
        size--;
    }

    /**
     * возвращает элемент, расположенный по указанному индексу;
     *
     * @param position позиция
     * @return элемент в масиве который размещен на заданной позиции
     */
    public T get(int position) {
        checkIndex(position);
        return (T) this.objects[position];
    }

    /**
     * give us length array
     * @return length array
     */
    public int length() {
        return size;
    }

    /**
     * @return iterator for elements to array
     */
    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator();
    }

    /**
     * check заданный пользователем индекс на наличие такого в масиве
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * внутренняя реализация итератора
     */
    private class SimpleArrayIterator implements Iterator<T> {
        private int index;

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
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return objects[index++];
        }
    }

}
