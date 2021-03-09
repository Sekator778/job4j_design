package array;

import org.junit.Test;

import static org.junit.Assert.*;

public class SymmetricDiffTest {
    @Test
    public void test() {
        assertArrayEquals(new int[] {}, SymmetricDiff.diff(new int[] {}, new int[] {}));
        assertArrayEquals(new int[] {1}, SymmetricDiff.diff(new int[] {1}, new int[] {}));
        assertArrayEquals(new int[] {1}, SymmetricDiff.diff(new int[] {}, new int[] {1}));
        assertArrayEquals(new int[] {}, SymmetricDiff.diff(new int[] {1}, new int[] {1}));
        assertArrayEquals(new int[] {1, 3}, SymmetricDiff.diff(new int[] {1, 2}, new int[] {2, 3}));
        assertArrayEquals(new int[] {1, 2, 3, 4}, SymmetricDiff.diff(new int[] {1, 2}, new int[] {3, 4}));
    }
}