package codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserStringTest {
    @Test
    public void whenTestMe() {
        assertArrayEquals(new int[] {8, 64}, ParserString.parse("iiisdoso"));
        assertArrayEquals(new int[] {8, 64, 3600}, ParserString.parse("iiisdosodddddiso"));
    }

}