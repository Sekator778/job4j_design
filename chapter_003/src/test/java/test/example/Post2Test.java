package test.example;

import org.junit.Before;
import org.junit.Test;
import test.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Post2Test {
    private final List<User> userList = new ArrayList<>();

    @Before
    public void setup() {
        List<String> user1Set = new ArrayList<>();
        user1Set.add("xxx@ya.ru");
        user1Set.add("foo@gmail.com");
        user1Set.add("lol@mail.ru");

        List<String> user2Set = new ArrayList<>();
        user2Set.add("foo@gmail.com");
        user2Set.add("ups@pisem.net");

        List<String> user3Set = new ArrayList<>();
        user3Set.add("xyz@pisem.net");
        user3Set.add("vasya@pupkin.com");

        List<String> user4Set = new ArrayList<>();
        user4Set.add("ups@pisem.net");
        user4Set.add("aaa@bbb.ru");

        List<String> user5Set = new ArrayList<>();
        user5Set.add("xyz@pisem.net");

        User user1 = new User("user1", user1Set);
        User user2 = new User("user2", user2Set);
        User user3 = new User("user3", user3Set);
        User user4 = new User("user4", user4Set);
        User user5 = new User("user5", user5Set);

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);

    }

    /**
     * будет время сравню мапы а так просто строки
     */
    @Test
    public void suchLongAwaitedTest() {
        Map<User, Set<String>> result = Post2.convert(userList);
        List<String> user1List = new ArrayList<>(List.of("aaa@bbb.ru", "ups@pisem.net", "lol@mail.ru", "xxx@ya.ru", "foo@gmail.com"));
        User user1 = new User("user1", user1List);
        List<String> user3List = new ArrayList<>(List.of("vasya@pupkin.com", "xyz@pisem.net"));
        User user3 = new User("user3", user3List);
        Map<User, List<String>> expected =
                Map.of(user1, user1List,
                        user3, user3List);

        assertThat(result.toString(), is("{name='user1', mails=[xxx@ya.ru, foo@gmail.com, lol@mail.ru]=[aaa@bbb.ru, ups@pisem.net, lol@mail.ru, xxx@ya.ru, foo@gmail.com], name='user3', mails=[xyz@pisem.net, vasya@pupkin.com]=[vasya@pupkin.com, xyz@pisem.net]}"));
    }

}