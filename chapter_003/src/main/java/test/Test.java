package test;

import java.util.TreeSet;

/**
 *
 */

public class Test {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet();
        set.add("Java");
        set.add("The");
        set.add("Java");
        set.add("JavaTheBest");
        for (String t : set
             ) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
}
