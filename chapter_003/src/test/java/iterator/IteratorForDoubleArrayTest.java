package iterator;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class IteratorForDoubleArrayTest {

    @Test
    public void next() {
        IteratorForDoubleArray iterator = new IteratorForDoubleArray(new int[][]{{1, 2, 3}, {4, 5}});

        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();

        int rsl = iterator.next();
        assertThat(rsl, is(5));
        }
    }
