package array;

import org.junit.Test;

import static org.junit.Assert.*;

public class DestroySequenceTest {
    @Test
    public void test() {
        assertArrayEquals("0000011111".toCharArray(), DestroySequence.destroy("1111100000".toCharArray()));
        assertArrayEquals("00000011111".toCharArray(), DestroySequence.destroy("11111000000".toCharArray()));
        assertArrayEquals("0000001011111".toCharArray(), DestroySequence.destroy("1111101000000".toCharArray()));
    }
}