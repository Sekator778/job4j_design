package array;

import java.util.Arrays;

/**
 * good, good good, good good, good good, good good, good good, good good, good
 * Даны два отсортированных по возрастанию массива. Как без сортировки их объединить в третий массив?
 */
public class Merge {
    public static int[] merge(int[] left, int[] right) {
        int[] b = new int[left.length + right.length];
        int positionLeft = 0;
        int positionRight = 0;

        for (int i = 0; i < b.length; i++) {
            if (positionLeft == left.length) {
                b[i] = right[positionRight];
                positionRight++;
            } else if (positionRight == right.length) {
                b[i] = left[positionLeft];
                positionLeft++;
            } else if (left[positionLeft] < right[positionRight]) {
                b[i] = left[positionLeft];
                positionLeft++;
            } else {
                b[i] = right[positionRight];
                positionRight++;
            }
        }
        return b;
    }
}
