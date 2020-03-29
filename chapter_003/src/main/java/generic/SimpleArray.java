package generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

/**
 * @author Sekator
 * this универсальная обертка над массивом
 */
public class SimpleArray<T> implements Iterable<T> {
    private final T[] elementData;
    private int size = 0;

    public SimpleArray(int size) {
        this.elementData = (T[]) new Object[size];
    }

    /**
     * - добавляет указанный элемент (model) в первую свободную ячейку;
     *
     * @param model - элемент
     */
    public void add(T model) {
        if (size == elementData.length) {
            throw new IllegalStateException("Array is full");
        }
        this.elementData[size++] = model;
    }

    /**
     * заменяет указанным элементом (model) элемент, находящийся по индексу index;
     *
     * @param index куда вставлять
     * @param model вставляемый елемент
     */
    public void set(int index, T model) {
        checkIndex(index);
        this.elementData[index] = model;
    }

    /**
     * удаляет элемент по указанному индексу, все находящиеся справа элементы
     * при этом необходимо сдвинуть на единицу влево (в середине массива не должно быть пустых ячеек);
     *
     * @param index - в каком месте удалять
     */
    public boolean remove(int index) {
        checkIndex(index);
        for (int i = index; i < elementData.length - 1; i++) {
            this.elementData[i] = this.elementData[i + 1];
        }
        size--;
        return true;
    }

    /**
     * возвращает элемент, расположенный по указанному индексу;
     *
     * @param position позиция
     * @return элемент в масиве который размещен на заданной позиции
     */
    public T get(int position) {
        checkIndex(position);
        return (T) this.elementData[position];
    }

    /**
     * give us length array
     * @return length array
     */
    public int length() {
        return size;
    }

    public int getIndex(T model) {
        int rsl = -1;
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i].equals(model)) {
                rsl = i;
                break;
            }
        }
        return rsl;
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
     * как такое сделать без предиката,
     * @param predicate - чего проверить
     * @return если тест дал тру то возвращаем номер индекса массива
     */
    public int indexBy(Predicate<T> predicate) {
        for (int i = 0; i < size; i++) {
            if (predicate.test(elementData[i])) {
                return i;
            }
        }
        return -1;
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
            return elementData[index++];
        }
    }
}
