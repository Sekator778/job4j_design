package array;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrArrayTest {
    @Test
    public void test() {
        assertArrayEquals(new int[] {}, OrArray.or(new int[] {}, new int[] {}));
        assertArrayEquals(new int[] {1}, OrArray.or(new int[] {1}, new int[] {}));
        assertArrayEquals(new int[] {1}, OrArray.or(new int[] {}, new int[] {1}));
        assertArrayEquals(new int[] {1, 2}, OrArray.or(new int[] {1, 2}, new int[] {1, 2}));
        assertArrayEquals(new int[] {1, 2, 3}, OrArray.or(new int[] {1, 2}, new int[] {1, 2, 3}));
        assertArrayEquals(new int[] {1, 2, 3}, OrArray.or(new int[] {1}, new int[] {2, 3}));
    }
}