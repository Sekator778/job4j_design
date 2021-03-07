package array;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordsToTextTest {

    @Test
    public void test() {
        assertEquals("Hello World", WordsToText.convert(new String[] {"Hello", "World"}));
        assertEquals("one two three", WordsToText.convert(new String[] {"one", "two", "three"}));
        assertEquals("one", WordsToText.convert(new String[] {"one"}));
    }

}