package array;

import org.junit.Test;

import static org.junit.Assert.*;

public class SumOfDifferencesTest {

    @Test
    public void test() {
        assertEquals(9, SumOfDifferences.sum(new int[] {10, 2, 1}));
        assertEquals(2, SumOfDifferences.sum(new int[] {3, 2, 1}));
        assertEquals(4, SumOfDifferences.sum(new int[] {5, 4, 3, 2, 1}));
        assertEquals(4, SumOfDifferences.sum(new int[] {5, 3, 1}));
    }

}