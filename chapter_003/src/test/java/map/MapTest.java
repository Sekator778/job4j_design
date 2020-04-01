package map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class MapTest {
    Calendar calendar1 = new GregorianCalendar();

    User user1 = new User("Bob", 1, calendar1);
    User user2 = new User("Bob", 1, calendar1);

    Map<User, Object> map = new HashMap<>();

    @Test
    public void whenNoChangeHashCodeAndEquals() {
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(map);
    }


}
