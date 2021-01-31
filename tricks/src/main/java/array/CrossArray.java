package array;

import java.util.Arrays;

/**
 * Нужно вывести на консоль числа, которые есть одновременно в первом и втором массиве.
 */
public class CrossArray {

    public static void printCrossEl(int[] left, int[] right) {
        for (int k : left) {
            for (int i : right) {
                if (k == i) {
                    System.out.println(k);
                }
            }
        }
    }
}
