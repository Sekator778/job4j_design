package set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class SimpleSetTest {
    private SimpleSet<String> set = new SimpleSet<>();
    @Before
    public void setup() {
        set.add("one");
        set.add("two");
        set.add("three");
    }
    @Test
    public void whenAdd() {
        assertTrue(set.add("four"));
        assertThat(set.toString(), is("[one, two, three, four]"));
    }

    @Test
    public void whenAddDuplicate() {
        assertFalse(set.add("two"));
        assertThat(set.toString(), is("[one, two, three]"));
    }

    @Test
    public void whenTestIteratorMoveToEndList() {
        Iterator<String> it = set.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("one"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("two"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("three"));
        assertThat(it.hasNext(), is(false));
    }
}
