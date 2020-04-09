package test.example;

import test.User;

import java.util.*;

/**
 *
 */

public class Post2 {
    public static void main(String[] args) {
        Map<User, String> input = new HashMap<>();

        HashSet<String> list1 = new HashSet<>(Set.of(
                "a1",
                "a2",
                "a3"
        ));

        HashSet<String> list2 = new HashSet<>(Set.of(
                "a1",
                "a4"
        ));

        User user1 = new User("user1", list1);
        User user2 = new User("user2", list2);

        input.put(user1, "a1");
        input.put(user1, "a2");
        input.put(user1, "a3");

        HashMap<String, User> output = new HashMap<>();
        input.forEach((k, v) -> System.out.println("-> " + k.getName() + " : " + v));
    }
}
