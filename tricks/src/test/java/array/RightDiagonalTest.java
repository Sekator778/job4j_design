package array;

import org.junit.Test;

import static org.junit.Assert.*;

public class RightDiagonalTest {

    @Test
    public void test() {
        int[][] data = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] expected = {3, 5, 7};
        assertArrayEquals(expected, RightDiagonal.diagonal(data));
    }

    @Test
    public void test2() {
        int[][] data = {
                {1, 2, 3, 4},
                {4, 5, 6, 7},
                {4, 5, 6, 7},
                {7, 8, 9, 10}
        };
        int[] expected = {4, 6, 5, 7};
        assertArrayEquals(expected, RightDiagonal.diagonal(data));
    }

}