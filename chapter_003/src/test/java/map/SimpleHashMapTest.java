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

    @Test
    public void testHashCode() {
        Calendar calendar1 = new GregorianCalendar();
        User user1 = new User("Bob", 1, calendar1);
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        SimpleHashMap<User, String> map1 = new SimpleHashMap<>();
        String s = "ome";
        System.out.println(map.index(s));
        System.out.println(map1.index(user1));
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
        SimpleHashMap<User, String> map = new SimpleHashMap<>();
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

        assertThat(map.get(user1), is("one"));
        assertThat(map.get(user2), is("two"));
        assertThat(map.get(user3), is("three"));
        assertThat(map.get(user4), is("four"));
        assertThat(map.get(user5), is("five"));
        assertThat(map.get(user6), is("six"));
        assertThat(map.get(user7), is("seven"));
        assertThat(map.get(user8), is("eight"));
        assertThat(map.get(user9), is("nine"));
        assertThat(map.get(user10), is("ten"));

        assertThat(map.remove(user1), is("one"));



    }
}
