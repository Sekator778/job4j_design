package generic;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {
    private final SimpleArray<String> stringSimpleArrayArray = new SimpleArray<>(2);
    private final SimpleArray<Integer> simpleArray = new SimpleArray<>(3);


    @Test
    public void whenCreateContainerShouldReturnStringType() {
        stringSimpleArrayArray.add("one");
        String result = stringSimpleArrayArray.get(0);

        assertThat(result, is("one"));
    }

    @Test
    public void whenCreateContainerShouldReturnIntegerType() {
        simpleArray.add(23);
        int result = simpleArray.get(0);

        assertThat(result, is(23));
    }

    @Test
    public void whenSetElement() {
        simpleArray.add(23);
        simpleArray.set(0, 32);
        int result = simpleArray.get(0);

        assertThat(result, is(32));
    }

    @Test
    public void whenRemoveElement() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.remove(1);
        int result = simpleArray.get(1);

        assertThat(result, is(3));
    }

    @Test
    public void whenUsingIteratorThenIterateOverElements() {
        stringSimpleArrayArray.add("11");
        stringSimpleArrayArray.add("22");
        Iterator<String> it = stringSimpleArrayArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("11"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("22"));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenAddTwoElementAndLengthTwo() {
        stringSimpleArrayArray.add("11");
        stringSimpleArrayArray.add("22");
        assertThat(stringSimpleArrayArray.length(), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUsingIteratorAfterLastElementThenThrowException() {
        simpleArray.add(23);
        Iterator<Integer> it = simpleArray.iterator();
        it.next();
        it.next();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetByIndexOutOfBoundsThenThrowsException() {
        simpleArray.add(23);
        simpleArray.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenSetByIndexOutOfBoundsThenThrowsException() {
        simpleArray.add(23);
        simpleArray.set(77, 23);
    }
}