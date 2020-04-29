package test.example;

import java.util.*;

public class PetrMail {

    public static Map<String, Set<String>> analyze(List<List<String>> input) {
        Map<String, String> one = new HashMap<>();
        Map<String, Set<String>> two = new HashMap<>();
        int names = 0;
        for (List<String> user : input) {
            String name = String.valueOf(names++);
            for (String el : user) {
                if (one.containsKey(el)) {
                    name = one.get(el);
                    break;
                }
            }
            two.putIfAbsent(name, new HashSet<>());
            Set<String> el = two.get(name);
            for (String gr : user) {
                el.add(gr);
            }
            for (String gr : user) {
                one.put(gr, name);
            }
        }
        return two;
    }

//    public static Map<User, Set<String>> analyze2(List<User> input) {
//        Map<String, User> one = new HashMap<>();
//        Map<User, Set<String>> two = new HashMap<>();
//        User names = null;
//        for (User user : input) {
////            User name = String.valueOf(names++);
//            User name = user;
//            for (String mail : user.getMails()) {
//                if (one.containsKey(mail)) {
//                    name = one.get(mail);
//                    break;
//                }
//            }
//            two.putIfAbsent(name, new HashSet<>());
//            Set<String> el = two.get(name);
//            for (String gr : user.getMails()) {
//                el.add(gr);
//            }
//            for (String gr : user.getMails()) {
//                one.put(gr, name);
//            }
//        }
//        return two;
//    }

    public static void main(String[] args) {

        System.out.println(analyze(
                Arrays.asList(
                        Arrays.asList("1", "2", "3"),
                        Arrays.asList("3", "4", "5"),
                        Arrays.asList("5", "6", "7")
                )
        ));

        System.out.println(analyze(
                Arrays.asList(
                        Arrays.asList("1", "2", "3"),
                        Arrays.asList("3", "4", "5"),
                        Arrays.asList("8", "6", "7")
                )
        ));
    }
}