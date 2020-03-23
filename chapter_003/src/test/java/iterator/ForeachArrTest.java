package iterator;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class ForeachArrTest {
    @Test
    public void whenForEachTest() {
        int[] values = new int[]{1, 2, 3, 41};
        int[] result = new int[values.length];
        int index = 0;
        ForeachArr foreachArr = new ForeachArr(new int[]{1, 2, 3, 41});
        for (Integer i : foreachArr
        ) {
            result[index++] = i;
        }
        assertArrayEquals(result, values);
    }
}