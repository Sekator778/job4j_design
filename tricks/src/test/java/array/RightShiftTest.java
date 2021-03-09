package array;

import org.junit.Test;

import static org.junit.Assert.*;

public class RightShiftTest {

    @Test
    public void testWhenShift1() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {5, 1, 2, 3, 4};
        RightShift.shift(input, 1);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testWhenShift2() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {4, 5, 1, 2, 3};
        RightShift.shift(input, 2);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testWhenShift5() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        RightShift.shift(input, 5);
        assertArrayEquals(expected, input);
    }
}