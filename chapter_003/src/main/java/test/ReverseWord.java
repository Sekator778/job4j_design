package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Sekator  : mail sekator778@gmail.com
 * есть два слова или вообще будь чего узнать состоят ли они
 * из тех же символов за время О(n)
 */

public class ReverseWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите 2 слова ");
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        Map<Character, Integer> map = new HashMap<>();
        char[] strings1 = s1.toCharArray();
        char[] strings2 = s2.toCharArray();
        for (int i = 0; i < strings1.length; i++) {
            map.put(strings1[i], 1);
        }
        for (int i = 0; i < strings2.length; i++) {
            if (!map.containsKey(strings2[i])) {
                System.out.println("Слова состоят из разных символов");
                break;
            }
            System.out.println("Слова состоят из одинаковых символов");
        }
    }
}
