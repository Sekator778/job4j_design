package iterator;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class IteratorForPairNumberTest {

    @Test
    public void hasNext() {
    }

    @Test
    public void next() {
        int[] values = new int[]{1, 2, 3, 41, 7};

        IteratorForPairIndexNumber pairNumber = new IteratorForPairIndexNumber(values);

        int rsl = pairNumber.next();

        assertThat(rsl, is(2));
    }
}