package array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DecodingTest {
    @Test
    public void decodeOne() {
        int[] ints = {5, 7, 8, 2, 1};
        int[] rsl = Decoding.decode(ints, 2);
        int[] expected = {1, 1, 0, 0, 1};
        assertThat(rsl, is(expected));
    }

    @Test
    public void decodeTwo() {
        int[] ints = {17, 11, 99, 55, 23, 1};
        int[] rsl = Decoding.decode(ints, 5);
        int[] expected = {2, 1, 4, 0, 3, 1};
        assertThat(rsl, is(expected));
    }
}