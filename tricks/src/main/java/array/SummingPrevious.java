package array;

import java.util.Arrays;

/**
 * Даны целые числа n (> 2), a и b.
 * Сформировать и вывести целочисленный массив размера n,
 * первый элемент которого равен a, второй равен b,
 * а каждый последующий элемент равен сумме всех предыдущих.
 */
public class SummingPrevious {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 6};
        System.out.println(Arrays.toString(calculate(1, 2, 4)));

    }
    public static int[] calculate(int a, int b, int n) {
        int[] result = new int[n];
        result[0] = a;
        result[1] = b;
        int sum = a + b;
        for (int i = 2; i < n; i++) {
            result[i] = sum;
            sum = sum + sum;
        }
    return result;
    }
}