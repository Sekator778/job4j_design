package test;

import java.util.*;

/**
 *
 */
public class Mail {
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
//        Map<String, User> output = convert(userList);
//        output.forEach((k, v) -> System.out.println("-> " + k + " : " + v.getName()));
//        System.out.println("user1 mails " + user1.getMails());
//        System.out.println("user3 mails " + user3.getMails());
//
//        Map<User, Set<String>> output = convert(userList);
//        output.forEach((k, v) -> System.out.println("-> " + k.getName() + " : " + v.toString()));
        somePublicMethod(userList);
    }

    public static Map<User, Set<String>> convert(List<User> input) {
        // первая тут будут уники мейлы и пользователь который последний добавил его
        Map<String, User> one = new HashMap<>();
        Map<User, Set<String>> two = new HashMap<>();

        // тут будут уники юзеры и мейлы из первой карты где он засветился с таким мейлом
        // выгружаем всех юзеров попорядку
        for (User user : input
        ) {
            User temp = user;
            // выгружаем каждого юзера почту по одной
            for (String email : user.getMails()
            ) {
                // если почты нет еще в
                if (!one.containsKey(email)) {
                    // то добавляем почту и юзера
                    one.put(email, temp);
                } else {
                    // но если есть то всю почту этого юзера кидаем тому кто ее уже принеc
                    one.get(email).getMails().addAll(temp.getMails());
                    for (String mail2 : one.get(email).getMails()) {
                        one.putIfAbsent(mail2, one.get(email));
                    }
                    break;
                }
                    two.put(one.get(email), one.get(email).getMails());
//                    temp = one.get(email);
            }
//            two.put(temp, temp.getMails());

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

        for (int i = 0; i < 100_000_000; i++) {
            convert(userList);
        }
        endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime) + "ms");
    }
}
