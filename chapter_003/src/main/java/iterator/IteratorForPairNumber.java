package iterator;

import java.util.Iterator;

public class IteratorForPairNumber implements Iterator<Integer> {
    private final int[] values;
    private int index = 0;

    public IteratorForPairNumber(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return values.length > index;
    }

    @Override
    public Integer next() {
        if ((index + 2) < values.length) {
            index += 2;
            return values[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
