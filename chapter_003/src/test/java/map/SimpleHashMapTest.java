package map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class SimpleHashMapTest {
    @Test
    public  void whenTest() {
        SimpleHashMap<User, String> map = new SimpleHashMap<>();
        Calendar calendar1 = new GregorianCalendar();

        User user1 = new User("Bob", 1, calendar1);
        User user2 = new User("Marvin", 2, calendar1);

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

        SimpleHashMap<User, String> map = new SimpleHashMap<>();
        System.out.println(map.put(user1, "one"));
        System.out.println(map.put(user2, "one"));
    }
}
