package array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EvenSumElementsTest {
    @Test
    public void checkArrayFalse() {
        int[] data = {1, 2, 3, 4, 5};
        boolean rsl = EvenSumElements.checkArray(data);
        assertThat(rsl, is(false));
    }

    @Test
    public void checkArrayTrue() {
        int[] data = {1, 2, 3, 4, 5, 6, 7};
        boolean rsl = EvenSumElements.checkArray(data);
        assertThat(rsl, is(true));
    }
}