package array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EditorElementsArrayTest {
    @Test
    public void changeData() {
        int[][] array = {{1, 8, 3}, {2, 4, 11}, {-10, 6, 5}};
        int el = 3;
        int[][] rsl = EditorElementsArray.changeData(array, el);
        int[][] expected = {{0, 5, 0}, {0, 1, 8}, {0, 3, 2}};
        assertThat(rsl, is(expected));
    }
    @Test
    public void changeDataTwo() {
        int[][] array = {{5}, {1, 4}, {-10, 18, 9}, {3, 2, 7, 11}};
        int el = 3;
        int[][] rsl = EditorElementsArray.changeData(array, el);
        int[][] expected = {{2}, {0, 1}, {0, 15, 6}, {0, 0, 4, 8}};
        assertThat(rsl, is(expected));
    }
}
