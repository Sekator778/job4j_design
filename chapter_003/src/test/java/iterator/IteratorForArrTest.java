package iterator;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.stringContainsInOrder;
import static org.junit.Assert.*;

public class IteratorForArrTest {

    @Test
    public void hasNext() {
        IteratorForArr iteratorArr = new IteratorForArr(new int[]{1, 2});

        iteratorArr.next();
        boolean rsl = iteratorArr.hasNext();

        assertTrue(rsl);
    }

    @Test
    public void next() {
        IteratorForArr iteratorArr = new IteratorForArr(new int[]{1, 2, 3});

        iteratorArr.next();
        iteratorArr.next();
        int rsl = iteratorArr.next();

        assertThat(rsl, is(3));
    }

    @Test
    public void previousTest() {
        IteratorForArr iteratorArr = new IteratorForArr(new int[]{1, 2, 3});

        iteratorArr.next();
        iteratorArr.next();
        int rsl = iteratorArr.previous();

        assertThat(rsl, is(1));
    }
}