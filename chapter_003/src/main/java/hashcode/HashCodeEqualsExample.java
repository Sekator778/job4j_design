package hashcode;

import map.SimpleHashMap;
import map.User;
import map.simple.SimpleHashChain;

import java.util.Calendar;

/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class HashCodeEqualsExample {
    public static void main(String[] args) {
        System.out.println("hashCode user");
        Calendar calendar = Calendar.getInstance();
        User user = new User("Alex", 2, calendar);
        for (int i = 0; i < 10; i++) {
            System.out.println(user.hashCode());
        }
        System.out.println("hashCode when generate SimpleHashMap");
        SimpleHashMap<User, Integer> map = new SimpleHashMap<>();
        for (int i = 0; i < 10; i++) {
            System.out.println(map.hash(user));
        }
        System.out.println("user change");
        user.setChildren(3);
        for (int i = 0; i < 10; i++) {
            System.out.println(map.hash(user));
        }
        System.out.println("hashCode when generate SimpleHashChain");
        SimpleHashChain<User, Integer> map2 = new SimpleHashChain<>();
        for (int i = 0; i < 10; i++) {
            System.out.println(map2.hashCode(user));
        }

        System.out.println("index when generate SimpleHashMap");
        for (int i = 0; i < 10; i++) {
            System.out.println(map.index(user));
        }
        System.out.println("index when generate SimpleHashChain");
        for (int i = 0; i < 10; i++) {
            System.out.println(map2.index(map2.hashCode(user)));
        }

    }
}
