package array;

/**
 * Если последовательность элементов удовлетворяет условию
 * Ak <= Ak+1 <= ... <= Ak+m она называется неубывающей.
 * Длина последовательности это количество элементов,
 * которые в нее входят.  В массиве таких последовательностей
 * может быть несколько, вам нужно найти длину максимальной из них.
 */

public class MaxLengthSeria {
    public static void main(String[] args) {
        int[] ar = new int[]{1, 2, 3};
        System.out.println(findMax(ar));
    }

    public static int find(int[] array) {
        int[] count = new int[100];
        int p = 1;
        int y = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                p++;
            } else {
                count[y++] = p;
                p = 1;
            }
            count[y++] = p;
        }
        return findMax(count);
    }

    private static int findMax(int[] array) {
        int max = 1;
        for (int j : array) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }
}