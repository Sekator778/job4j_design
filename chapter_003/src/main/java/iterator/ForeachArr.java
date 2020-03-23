package iterator;

import java.util.Iterator;

public class ForeachArr implements Iterable<Integer> {
    private final int[] values;

    public ForeachArr(int[] values) {
        this.values = values;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IteratorForArr(this.values);
    }
}
