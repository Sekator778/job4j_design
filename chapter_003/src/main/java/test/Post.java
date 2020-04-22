//package test;
//
//import java.util.*;
//
//public class Post {
//
//    public static void main(String[] args) {
//        HashSet<String> user1Set = new HashSet<>();
//        user1Set.add("xxx@ya.ru");
//        user1Set.add("foo@gmail.com");
//        user1Set.add("lol@mail.ru");
//        HashSet<String> user2Set = new HashSet<>();
//        user2Set.add("foo@gmail.com");
//        user2Set.add("ups@pisem.net");
//        HashSet<String> user3Set = new HashSet<>();
//        user3Set.add("xyz@pisem.net");
//        user3Set.add("vasya@pupkin.com");
//        HashSet<String> user4Set = new HashSet<>();
//        user4Set.add("ups@pisem.net");
//        user4Set.add("aaa@bbb.ru");
//        HashSet<String> user5Set = new HashSet<>();
//        user5Set.add("xyz@pisem.net");
//        User user1 = new User("user1", user1Set);
//        User user2 = new User("user2", user2Set);
//        User user3 = new User("user3", user3Set);
//        User user4 = new User("user4", user4Set);
//        User user5 = new User("user5", user5Set);
//        Map<String, HashSet<String>> output = new HashMap<>();
//        HashSet<String> result;
//
//        List<User> userList = new ArrayList<>(List.of(
//                user1,
//                user2,
//                user3,
//                user4,
//                user5
//        ));
//
//        for (int i = 0; i < userList.size(); i++) {
//            for (int j = i + 1; j < userList.size(); j++) {
//                if ((checkDuble(userList.get(i).mails, userList.get(j).mails) && !userList.get(i).isProcessed)) {
//                    result = merger(userList.get(i).mails, userList.get(j).mails);
//                    userList.get(j).isProcessed = true;
//                    output.put(userList.get(i).name, result);
//                    break;
//                }
//            }
//        }
//        output.forEach((k, v) -> System.out.println("-> " + k + " : " + v.toString()));
//    }
//
//    public static boolean checkDuble(HashSet<String> one, HashSet<String> two) {
//        boolean rsl = false;
//        for (String mail : one
//        ) {
//            if (two.contains(mail)) {
//                rsl = true;
//                break;
//            }
//        }
//        return rsl;
//    }
//
//    public static HashSet<String> merger(HashSet<String> one, HashSet<String> two) {
//        HashSet<String> result = new HashSet<>(one);
//        result.addAll(two);
//        return result;
//    }
//    private static class User {
//        String name;
//        Set<String> mails;
//        boolean isProcessed = false;
//
//        public User(String name, Set<String> mails) {
//            this.name = name;
//            this.mails = mails;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public Set<String> getMails() {
//            return mails;
//        }
//
//        @Override
//        public String toString() {
//            return "name='" + name + '\'' + ", mails=" + mails;
//        }
//    }
//}