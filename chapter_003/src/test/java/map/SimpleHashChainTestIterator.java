package map;

import map.simple.Node;
import map.simple.SimpleHashChain;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class SimpleHashChainTestIterator {
     SimpleHashChain<Integer, User> map;
    @Before
    public void setup() {
        Calendar calendar = Calendar.getInstance();
        map = new SimpleHashChain<>();
        map.put(1, new User("Sasha", 2, calendar));
        map.put(2, new User("Vasya", 2, calendar));
        map.put(3, new User("Katya", 2, calendar));
        map.put(4, new User("Nastya", 2, calendar));
        map.put(5, new User("Petya", 2, calendar));
        map.put(6, new User("Georgi", 2, calendar));
    }

    @Test
    public void iteratorTestNextAndHaveNext() {
        Iterator<Node<Integer, User>> iterator = map.iterator();
        assertTrue(iterator.hasNext());
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void iteratorTestNext() {
        assertThat(map.size, is(6));
        assertThat(map.length(), is(16));
        Iterator<Node<Integer, User>> iterator = map.iterator();
        assertTrue(iterator.hasNext());
        assertTrue(map.delete(1));
        assertTrue(map.delete(2));
        assertTrue(map.delete(3));
        assertTrue(map.delete(4));
        assertTrue(map.delete(5));
        assertTrue(map.delete(6));
        assertFalse(iterator.hasNext());
    }

    @Test
    public void whenTestSizeAndLengthTablesOnlyStudyGoals() {
        assertThat(map.size, is(6));
        assertThat(map.length(), is(16));
        assertTrue(map.delete(1));
        assertTrue(map.delete(2));
        assertTrue(map.delete(3));
        assertTrue(map.delete(4));
        assertTrue(map.delete(5));
        assertTrue(map.delete(6));
        assertThat(map.size, is(0));
        assertThat(map.length(), is(16));
    }
    @Test
    public void whenResizeMap() {
        SimpleHashChain<Integer, User> map2 = new SimpleHashChain<>();
        Calendar calendar = Calendar.getInstance();
        User user = new User("Kiril", 5, calendar);
        assertThat(map.length(), is(16));
        for (int i = 0; i < 16; i++) {
            map2.put(i, user);
        }
        assertThat(map2.length(), is(16));
        map2.put(17, user);
        assertThat(map2.length(), is(32));
    }
}
