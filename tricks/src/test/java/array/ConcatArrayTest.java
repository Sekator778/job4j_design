package array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConcatArrayTest {
    @Test
    public void whenMethodReturnResultEight() {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6, 7, 8};
        int expected = 8;
        int rsl = ConcatArray.combineSize(a, b);
        assertThat(expected, is(rsl));
    }

    @Test
    public void whenMethodReturnResultTwelve() {
        int[] a = {1, 2, 3, 4};
        int[] b = {4, 5, 6, 7, 8, 9, 10, 11};
        int expected = 12;
        int rsl = ConcatArray.combineSize(a, b);
        assertThat(expected, is(rsl));
    }
}