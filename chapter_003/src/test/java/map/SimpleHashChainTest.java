package map;

import map.simple.SimpleHashChain;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class SimpleHashChainTest {

    @Test
    public void whenInsertAndGet() {
        Calendar calendar1 = new GregorianCalendar();

        User user1 = new User("Bob", 1, calendar1);
        User user2 = new User("Marvin", 2, calendar1);

        SimpleHashChain<User, String> map = new SimpleHashChain<User, String>();
        map.put(user1, "one");
        map.put(user2, "two");
        assertThat(map.get(user1), is("one"));
        assertThat(map.get(user2), is("two"));
    }

    @Test
    public void whenInsertTheSameObjectAndGet() {
        Calendar calendar1 = new GregorianCalendar();

        User user1 = new User("Bob", 1, calendar1);
        User user2 = new User("Bob", 1, calendar1);

        SimpleHashChain<User, String> map = new SimpleHashChain<User, String>();
        assertTrue(map.put(user1, "one"));
        assertFalse(map.put(user2, "two"));

    }
}
