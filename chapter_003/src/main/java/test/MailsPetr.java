package test;

import java.util.*;

/**
 * Вариант Петра
 */
public class MailsPetr {
    public static void main(String[] args) {
        Set<String> user1Set = new LinkedHashSet<>();
        user1Set.add("xxx@ya.ru");
        user1Set.add("foo@gmail.com");
        user1Set.add("lol@mail.ru");

        Set<String> user2Set = new LinkedHashSet<>();
        user2Set.add("foo@gmail.com");
        user2Set.add("ups@pisem.net");

        Set<String> user3Set = new LinkedHashSet<>();
        user3Set.add("xyz@pisem.net");
        user3Set.add("vasya@pupkin.com");

        Set<String> user4Set = new LinkedHashSet<>();
        user4Set.add("ups@pisem.net");
        user4Set.add("aaa@bbb.ru");

        Set<String> user5Set = new LinkedHashSet<>();
        user5Set.add("xyz@pisem.net");

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
        somePublicMethod(userList);

//        Map<User, Set<String>> output = convert2(userList);
//        output.forEach((k, v) -> System.out.println("-> " + k.getName() + " : " + v.toString()));
    }

    public static Map<User, Set<String>> convert2(List<User> input) {
        Map<String, User> one = new HashMap<>();
        Map<User, Set<String>> two = new HashMap<>();
        User names = null;
        for (User user : input) {
            User name = user;
            for (String mail : user.getMails()) {
                if (one.containsKey(mail)) {
                    name = one.get(mail);
                    break;
                }
            }
            two.putIfAbsent(name, new HashSet<>());
            Set<String> el = two.get(name);
            for (String gr : user.getMails()) {
                el.add(gr);
            }
            for (String gr : user.getMails()) {
                one.put(gr, name);
            }
        }
        return two;
    }

    private static class User {
        String name;
        Set<String> mails;
        boolean isProcessed = false;

        public User(String name, Set<String> mails) {
            this.name = name;
            this.mails = mails;
        }

        public String getName() {
            return name;
        }

        public Set<String> getMails() {
            return mails;
        }

        @Override
        public String toString() {
            return "name='" + name + '\'' + ", mails=" + mails;
        }
    }
    public  static void somePublicMethod(List<User> userList) {
        long startTime = 0;
        long endTime = 0;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            convert2(userList);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + "ms");
    }
}
