package iterator;

import java.util.Iterator;

public class IteratorForArr implements Iterator<Integer> {
    private final int[] values;
    private int index = 0;

    public IteratorForArr(final int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return values.length > index;
    }

    @Override
    public Integer next() {
        return values[index++];
    }

    /**
     * @return - previous element
     */
    public Integer previous() {
        return values[index - 2];
    }
}
