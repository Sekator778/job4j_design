package array;

/**
 * Дано число int. Нужно получить массив из его цифр в обратном порядке.
 * <p>
 * Например
 * <p>
 * 12345 => {5, 4, 3, 2, 1}
 */
public class NumberToArray {
    public static int[] resolve(int number) {
        String s = String.valueOf(number);
        int[] ints = new int[s.length()];
        int k = 0;
        char[] input = s.toCharArray();
        for (int i = input.length - 1; i >= 0; i--) {
            ints[k++] = Integer.parseInt(String.valueOf(input[i]));
        }
        return ints;
    }
}
