package array;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwapRowsTest {

    @Test
    public void test() {
        int[][] data = {
                {1, 2, 3},
                {4, 5, 6}
        };
        SwapRows.swap(data, 0, 1);
        assertArrayEquals(
                new int[][] {
                        {4, 5, 6},
                        {1, 2, 3}
                },
                data
        );
    }

    @Test
    public void testMult() {
        int[][] data = {
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5}
        };
        SwapRows.swap(data, 2, 0);
        assertArrayEquals(
                new int[][] {
                        {3, 3, 3, 3, 3},
                        {2, 2, 2, 2, 2},
                        {1, 1, 1, 1, 1},
                        {4, 4, 4, 4, 4},
                        {5, 5, 5, 5, 5}
                },
                data
        );
    }

}