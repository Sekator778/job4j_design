package array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UnionThreeArraysTest {
    @Test
    public void union() {
        int[] left = {1, 2, 3, 4, 5};
        int[] middle = {6, 7, 8, 9, 10};
        int[] right = {11, 12, 13, 14, 15, 16};
        int[] rsl = UnionThreeArrays.union(left, middle, right);
        int[] expected = {1, 11, 7, 13, 9, 15, 5};
        assertThat(rsl, is(expected));
    }

    @Test
    public void unionReturnArrayWith5Elements() {
        int[] left = {1, 2, 3};
        int[] middle = {4, 5, 6};
        int[] right = {7, 8, 9, 10};
        int[] rsl = UnionThreeArrays.union(left, middle, right);
        int[] expected = {1, 7, 5, 9, 3};
        assertThat(rsl, is(expected));
    }
}