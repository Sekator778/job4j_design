package array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArrayInSquareArrayTest {
    @Test
    public void convertArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        int[][] rsl = ArrayInSquareArray.convertArray(array);
        assertThat(rsl, is(expected));
    }

    @Test
    public void convertArray9() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[][] expected = {{1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9, 10, 0, 0},
                             {0, 0, 0, 0}};
        int[][] rsl = ArrayInSquareArray.convertArray(array);
        assertThat(rsl, is(expected));
    }

    @Test
    public void convertArray3Elements() {
        int[] array = {1, 2, 3};
        int[][] expected = {{1, 2}, {3, 0}};
        int[][] rsl = ArrayInSquareArray.convertArray(array);
        assertThat(rsl, is(expected));
    }
}