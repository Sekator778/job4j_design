package iterator;

import java.util.Iterator;

/**
 * итератор для двухмерного массива.
 */
public class IteratorForDoubleArray implements Iterator<Integer> {
    private final int[][] values;
    private int x = 0;
    private int y = 0;

    public IteratorForDoubleArray(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return ((x < values.length - 1) || (y < values[x].length));
    }

    /**
     *сначало идем по Y если жошли до конца values[x].length - 1) < y
     * то спускаемся на x++ , а y = 0
     * @return елемент
     */
    @Override
    public Integer next() {
        int rsl;
        if ((values[x].length - 1) < y) {
            x++;
            y = 0;
        }
        rsl = values[x][y++];
        return rsl;
    }
}
