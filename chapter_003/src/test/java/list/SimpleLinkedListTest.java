package list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleLinkedListTest {
    private final SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

    @Before
    public void setup() {
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenTestToString() {
        assertThat(list.toString(), is("[1, 2, 3]"));
    }

    @Test
    public void whenGetFirst() {
        assertThat(list.get(), is(1));
    }

    @Test
    public void whenGiveOnAnIndex() {
        assertThat(list.get(2), is(3));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundList() {
        list.get(3);
    }

    @Test
    public void whenHaveNext() {
        Iterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(1));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(2));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(3));
        assertFalse(iterator.hasNext());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenHaveModificationListAfterIterator() {
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.next(), is(1));
        list.add(23);
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmptyList() {
        SimpleLinkedList<Integer> list1 = new SimpleLinkedList<>();
        list1.get();
    }

    @Test
    public void whenDeleteFirstElement() {
        assertThat(list.get(0), is(1));
        assertThat(list.size(), is(3));
        assertThat(list.remove(0), is(1));
        assertThat(list.size(), is(2));
    }

    @Test
    public void whenDeleteAnotherElement() {
        assertThat(list.get(1), is(2));
        assertThat(list.remove(1), is(2));
        assertThat(list.get(1), is(3));



    }
}