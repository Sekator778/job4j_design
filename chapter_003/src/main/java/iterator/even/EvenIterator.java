package iterator.even;

import java.util.Iterator;

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
        int rsl = 0;
        if (evenNext()) {
            if (even(index)) {
                rsl = values[index];
                return rsl;
            } else {
                index = index + 1;
                next();
            }
        }
        return rsl;
    }

    public boolean even(int x) {
        return ((this.values[x] % 2) == 0);
    }

    public boolean evenNext() {
        boolean rsl = false;
        for (int i = index; i < values.length; i++) {
            if (even(i)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }
}
