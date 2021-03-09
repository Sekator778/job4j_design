package array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DividerTest {
    @Test
    public void checkTrue() {
        int[] ints = {2, 3, 4};
        boolean check = Divider.check(12, ints);
        assertThat(check, is(true));
    }

    @Test
    public void checkFalse() {
        int[] ints = {1, 2, 3, 6, 9, 11};
        boolean check = Divider.check(18, ints);
        assertThat(check, is(false));
    }
}