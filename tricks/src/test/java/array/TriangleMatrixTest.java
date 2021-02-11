package array;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleMatrixTest {

    @Test
    public void whenRows1() {
        int[][] result = {
                {1}
        };
        assertArrayEquals(result, TriangleMatrix.rows(1));
    }

    @Test
    public void whenRows2() {
        int[][] result = {
                {1}, {2, 3}
        };
        assertArrayEquals(result, TriangleMatrix.rows(2));
    }

    @Test
    public void whenRows3() {
        int[][] result = {
                {1}, {2, 3}, {4, 5, 6}
        };
        assertArrayEquals(result, TriangleMatrix.rows(3));
    }

}