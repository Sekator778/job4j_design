package codewars;

import java.util.Arrays;

public class FactorialZero {
    public static int zeros(int n) {
        String number = String.valueOf(factorial(n));
        if (number.length() == 1) {
            return 0;
        }
        char[] characters = number.toCharArray();
        int count = 0;
        for (int i = characters.length - 1; i >= 0; i--) {
            if (characters[i] == '0') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private static long factorial(int n) {
        if (n <= 2) {
            return n;
        }
        return n * factorial(n - 1);
    }
}
