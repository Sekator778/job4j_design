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
    public void whenTest() {
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
        assertThat(map.put(user1, "one"), is("one"));
        assertThat(map.put(user2, "two"), is("one"));
        assertThat(map.put(user1, "one"), is("one"));

    }

    /**
     * не помню для чего это надо всегда комменты писать
     */
    @Test
    public void testHashCode() {
        Calendar calendar1 = new GregorianCalendar();
        User user1 = new User("Bob", 1, calendar1);
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        SimpleHashMap<User, String> map1 = new SimpleHashMap<>();
    }

    @Test
    public void whenInsert10ObjectAndResizeMapTwoTimes() {
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
        assertThat(map.size(), is(4));
        assertThat(map.getCount(), is(3));
        map.put(user4, "four");
        assertThat(map.size(), is(4));
        map.put(user5, "five");
        // посмотреть где кто лежит интересно
//        map.viewTable();
        assertThat(map.getCount(), is(5));
        // а так если через threshold
        assertThat(map.size(), is(8));
        map.put(user6, "six");
        // посмотреть где кто лежит интересно
//        System.out.println("after resize");
//        map.viewTable();
        assertThat(map.getCount(), is(6));
        assertThat(map.size(), is(8));
        // странным образом настроился тут хешфункция что ресайзает после 7 елемента так будет
        // если неправильно ресайзать через лоадфактор
        map.put(user7, "seven");
        assertThat(map.getCount(), is(7));
        assertThat(map.size(), is(8));
        map.put(user8, "eight");
        map.put(user9, "nine");
        map.put(user10, "ten");
        assertThat(map.getCount(), is(10));
// посмотреть где кто лежит интересно
        map.viewTable();

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
        assertThat(map.remove(user3), is("three"));
        assertThat(map.remove(user5), is("five"));
        assertThat(map.remove(user7), is("seven"));

    }

    /**
     * при добавлении null обьект должен попасть в ячейку с
     * индексом 0
     */
    @Test
    public void testPutNull() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        for (int i = 0; i < 23; i++) {
            assertThat(map.index(null), is(0));
        }
    }

    @Test
    public void testToString() {
        Calendar calendar1 = new GregorianCalendar();
        User user1 = new User("Bob", 1, calendar1);
        User user2 = new User("Степан", 2, calendar1);
        User user3 = new User("Микола", 3, calendar1);
        User user4 = new User("Богдан", 4, calendar1);
        SimpleHashMap<User, String> map = new SimpleHashMap<>();
        map.put(user1, "one");
        map.put(user2, "two");
        map.put(user3, "three");
        map.put(user4, "four");

        System.out.println(map);

    }
}
