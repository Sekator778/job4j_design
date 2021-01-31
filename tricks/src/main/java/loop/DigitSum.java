package loop;

/**
 * Дано число, нужно получить сумму его цифр
 *
 * Например,
 *
 * 12 => 1 + 2 => 3
 */
public class DigitSum {
    public static int sum(int num) {
        int sum = 0;
        while (num >= 10) {
            sum += num % 10;
            num = num / 10;
        }
        sum = sum + num;
        return sum;
    }
}
