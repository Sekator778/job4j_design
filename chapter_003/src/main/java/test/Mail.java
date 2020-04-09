package test;

import java.util.*;

/**
 *
 */

public class Mail {
    public static void main(String[] args) {
        HashSet<String> user1Set = new HashSet<>();
        user1Set.add("xxx@ya.ru");
        user1Set.add("foo@gmail.com");
        user1Set.add("lol@mail.ru");

        HashSet<String> user2Set = new HashSet<>();
        user2Set.add("foo@gmail.com");
        user2Set.add("ups@pisem.net");

        HashSet<String> user3Set = new HashSet<>();
        user3Set.add("xyz@pisem.net");
        user3Set.add("vasya@pupkin.com");

        HashSet<String> user4Set = new HashSet<>();
        user4Set.add("ups@pisem.net");
        user4Set.add("aaa@bbb.ru");

        HashSet<String> user5Set = new HashSet<>();
        user5Set.add("xyz@pisem.net");
//-> aaa@bbb.ru : user4
//-> ups@pisem.net : user4
//-> lol@mail.ru : user1
//-> xxx@ya.ru : user1
//-> vasya@pupkin.com : user3  **
//-> foo@gmail.com : user2
//-> xyz@pisem.net : user5   **

        User user1 = new User("user1", user1Set);
        User user2 = new User("user2", user2Set);
        User user3 = new User("user3", user3Set);
        User user4 = new User("user4", user4Set);
        User user5 = new User("user5", user5Set);

        List<User> userList = new ArrayList<>(List.of(
                user1,
                user2,
                user3,
                user4,
                user5
        ));
        Map<User, Set<String>> output = convert(userList);
        output.forEach((k, v) -> System.out.println("-> " + k.getName() + " : " + v.toString()));

    }

    public static  Map<User, Set<String>> convert(List<User> input) {
        Map<String, User> one = new HashMap<>();
        Map<User, Set<String>> two = new HashMap<>();

        HashSet<String> addMail = new HashSet<>();
        for (User  user : input
             ) {
            for (String mail : user.mails
                 ) {
                one.put(mail, user);
                if (!one.containsKey(mail)) { /////////////////////////////////
                    assert addMail != null;
                    addMail.addAll(user.mails);
                    two.put(user, addMail);
                } else {
                    two.put(user, one.get(mail).mails);
                }
                addMail = null;
            }
        }
        return two;
    }
}
