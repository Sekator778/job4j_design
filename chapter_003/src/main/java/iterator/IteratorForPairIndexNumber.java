package iterator;

import java.util.Iterator;

/**
 * итератор для четных елементов масива
 */
public class IteratorForPairIndexNumber implements Iterator<Integer> {
    private final int[] values;
    private int index = 0;

    public IteratorForPairIndexNumber(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return values.length > index;
    }

    /**
     * тут просто чекаем пару
     * @return - елемент
     */
    @Override
    public Integer next() {
        if ((index + 2) < values.length) {
            return index + 2;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
