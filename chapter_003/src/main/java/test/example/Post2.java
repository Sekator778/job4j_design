package test.example;

import test.User;

import java.util.*;
import java.util.stream.Collectors;

public class Post2 {
    public static void main(String[] args) {
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

    public static Map<User, Set<String>> convert(List<User> input) {
        Map<String, User> one = new HashMap<>();
        for (User user : input
        ) {
            User temp = user;
            for (String email : user.getMails()
            ) {
                one.putIfAbsent(email, temp);
                if (!one.containsValue(temp)) {
                    temp = one.get(email);
                }
            }
        }
        return one.entrySet().stream().collect(Collectors.groupingBy(
                Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toSet())));
    }
}
