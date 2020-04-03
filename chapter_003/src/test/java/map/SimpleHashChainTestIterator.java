package map;

import map.simple.Node;
import map.simple.SimpleHashChain;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
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
@Test
    public void whenInsert10ObjectAndGet() {
        Calendar calendar1 = new GregorianCalendar();

        User user1 = new User("Bob", 1, calendar1);
        User user2 = new User("Степан", 2, calendar1);
        User user3 = new User("Микола", 3, calendar1);
        User user4 = new User("Богдан", 4, calendar1);
        User user5 = new User("Тарас", 5, calendar1);
        User user6 = new User("Петро", 0, calendar1);
        User user7 = new User("Иван", 33, calendar1);
        User user8 = new User("Сергей", 7, calendar1);
        User user9 = new User("Щехтось", 9, calendar1);
        User user10 = new User("ИншийМужик", 10, calendar1);

        SimpleHashChain<User, String> map = new SimpleHashChain<>();
        map.put(user1, "one");
        map.put(user2, "two");
        map.put(user3, "three");
        map.put(user4, "four");
        map.put(user5, "five");
        map.put(user6, "six");
        map.put(user7, "seven");
        map.put(user8, "eight");
        map.put(user9, "nine");
        map.put(user10, "ten");

//        assertThat(map.get(user1), is("one"));
//        assertThat(map.get(user2), is("two"));
//        assertThat(map.get(user3), is("three"));
//        assertThat(map.get(user4), is("four"));
//        assertThat(map.get(user5), is("five"));
//        assertThat(map.get(user6), is("six"));
//        assertThat(map.get(user7), is("seven"));
//        assertThat(map.get(user8), is("eight"));
//        assertThat(map.get(user9), is("nine"));
//        assertThat(map.get(user10), is("ten"));

    }
}
