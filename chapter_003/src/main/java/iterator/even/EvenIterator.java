package iterator.even;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * this cod find even number for array
 * example new int[]{1, 2, 3, 4, 5, 6, 7}
 * must find 2, 4
 * <p>
 * method hasNext gives true only when even
 * example = 1, -> hasNext -> 3, 4,  -true
 * example = 1, -> hasNext -> 3, 5,  -false
 */
public class EvenIterator implements Iterator<Integer> {
    private final int[] values;
    private int index;

    public EvenIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return evenNext();
    }

    @Override
    public Integer next() {
        if (!evenNext()) {
            throw new NoSuchElementException();
        }
        return values[index++];
    }

    /**
     * check number even or no
     *
     * @param x - number for check
     * @return - true if even number
     */
    public boolean even(int x) {
        return ((this.values[x] % 2) == 0);
    }

    /**
     * method find even to the end of the array
     *
     * @return - are the or not even element in the array
     */

    public boolean evenNext() {
        boolean rsl = false;
        for (int i = index; i < values.length; i++) {
            if (even(i)) {
                rsl = true;
                this.index = i;
                break;
            }
        }
        return rsl;
    }
}
