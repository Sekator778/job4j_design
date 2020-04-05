package tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class TreeIteratorTest {
    private final Tree<Integer> tree = new Tree<>(1);
    private final Iterator<Integer> iterator = tree.iterator();

    @Test(expected = NoSuchElementException.class)
    public void whenNotNextElementShouldException() {
        iterator.next();
        iterator.next();
    }

    @Test
    public void whenIteratorGiveAllElements() {
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(2, 5);
        tree.add(2, 6);
        tree.add(3, 7);
        tree.add(3, 8);
        tree.add(7, 9);
        int i = 1;
        for (Integer el : tree) {
            assertThat(el, is(i++));
        }
    }

    @Test
    public void whenNotNextElementShouldFalse() {
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        assertTrue(iterator.hasNext());
        iterator.next(); // skip head
        Assert.assertThat(iterator.next(), is(2));
        Assert.assertThat(iterator.next(), is(3));
        Assert.assertThat(iterator.next(), is(4));
        assertFalse(iterator.hasNext());

    }
}
