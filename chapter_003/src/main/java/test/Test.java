package test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 */

public class Test {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("Java");
        set.add("The");
        set.add("Java");
        set.add("JavaTheBest");
        for (String t : set
             ) {
            System.out.print(t + " ");
        }
        System.out.println();
        Set<String> set1 = new HashSet<>();
        set1.add("as");
        set1.add("av");
        set1.add("as");
        System.out.println(set1);
    }
}
