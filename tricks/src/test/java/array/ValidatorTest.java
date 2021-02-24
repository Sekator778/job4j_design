package array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidatorTest {
    @Test
    public void checkArrayFalse() {
        int[] data = {1, 2, 1, 3, 1, 4, 1};
        int value = 1;
        boolean rsl = Validator.checkArray(data, value);
        assertThat(rsl, is(false));
    }

    @Test
    public void checkArrayTrue() {
        int[] data = {1, 2, 3, 1, 4, 1, 5, 6, 7, 1, 8, 9};
        int value = 1;
        boolean rsl = Validator.checkArray(data, value);
        assertThat(rsl, is(true));
    }
}