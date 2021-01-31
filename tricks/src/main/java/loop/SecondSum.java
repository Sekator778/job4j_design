package loop;

/**
 * Даны два целых положительных числа a и b (b > a). Надо сложить каждое второе число в диапазоне [a, b] начиная с первого
 * <p>
 * Например,
 * <p>
 * [1, 2] => 1
 * <p>
 * [1, 3] => 1 + 3 = 4
 * <p>
 * [1, 5] => 1 + 3 + 5 = 9
 * <p>
 * [0, 5] => 0 + 2 + 4 + 6 = 12
 */
public class SecondSum {
    public static int sum(int a, int b) {
        int x = a + 2;
        while (x <= b) {
            a += x;
            x = x + 2;
        }
    return a;
    }
}
