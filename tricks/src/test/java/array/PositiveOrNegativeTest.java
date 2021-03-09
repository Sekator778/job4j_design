package array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PositiveOrNegativeTest {
    @Test
    public void checkTrue() {
        int[] data = {-5, -4, -3, -2, -1, 1, 2, 3, 4, 5};
        boolean check = PositiveOrNegative.check(data);
        assertThat(check, is(true));
    }

    @Test
    public void checkFalse() {
        int[] data = {-6, -5, -4, -3, -2, -1, 1, 2, 3, 4};
        boolean check = PositiveOrNegative.check(data);
        assertThat(check, is(false));
    }
}