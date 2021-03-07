package array;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberToArrayTest {
    @Test
    public void test() {
        assertArrayEquals(new int[] {1}, NumberToArray.resolve(1));
        assertArrayEquals(new int[] {2, 1}, NumberToArray.resolve(12));
        assertArrayEquals(new int[] {3, 2, 1}, NumberToArray.resolve(123));
        assertArrayEquals(new int[] {4, 3, 2, 1}, NumberToArray.resolve(1234));
        assertArrayEquals(new int[] {5, 4, 3, 2, 1}, NumberToArray.resolve(12345));
        assertArrayEquals(new int[] {6, 5, 4, 3, 2, 1}, NumberToArray.resolve(123456));
        assertArrayEquals(new int[] {7, 6, 5, 4, 3, 2, 1}, NumberToArray.resolve(1234567));
        assertArrayEquals(new int[] {8, 7, 6, 5, 4, 3, 2, 1}, NumberToArray.resolve(12345678));
        assertArrayEquals(new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1}, NumberToArray.resolve(123456789));
    }
}