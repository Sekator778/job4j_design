package map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class SimpleTestMap {
    @Test
    public void testDeleteMap() {
        Map<User, String> map = new HashMap<>();
        Calendar calendar1 = new GregorianCalendar();
        User user1 = new User("Bob", 1, calendar1);
        User user2 = new User("Степан", 2, calendar1);
        User user3 = new User("Микола", 3, calendar1);
        map.put(user1, "one");
        map.put(user2, "two");
        map.put(user3, "three");

        assertThat(map.get(user1), is("one"));
        assertThat(map.get(user2), is("two"));
        assertThat(map.get(user3), is("three"));

        assertThat(map.remove(user1), is("one"));
        assertThat(map.remove(user1), is(nullValue()));

    }
}
