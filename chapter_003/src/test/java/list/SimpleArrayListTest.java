package list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class SimpleArrayListTest {
    @Test
    public void whenAddElementAndGrowSizeArray() {
        SimpleArrayList<Integer> list = new SimpleArrayList(2);
        assertThat(list.length(), is(0));
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        assertThat(list.length(), is(10));
        list.add(11);
        assertThat(list.length(), is(11));
        assertThat(list.get(4), is(5));
    }

    @Test
    public void whenIteratorWorkingWithoutModification() {
        SimpleArrayList<Integer> list = new SimpleArrayList(2);
        list.add(1);
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        iterator.next();
        boolean rsl = iterator.hasNext();
        iterator.next();
        assertTrue(rsl);
        rsl = iterator.hasNext();
        assertFalse(rsl);
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenHaveModificationAfterCreateIterator() {
        SimpleArrayList<Integer> list = new SimpleArrayList(2);
        list.add(1);
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        iterator.next();
        boolean rsl = iterator.hasNext();
        iterator.next();
        assertTrue(rsl);
        list.add(3);
        iterator.next();
    }
}
