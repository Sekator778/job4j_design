package array;

import java.util.Arrays;

/**
 * Метод принимает массив целочисленных значений.
 * Необходимо перебрать этот массив выбрать из него
 * только нечетные числа и вернуть новый массив, в котором
 * будут только нечетные числа. При этом длина нового массива
 * должна совпадать с количеством нечетных значений в исходном массиве.
 */
public class ArrayWithoutEvenElements {
    public static int[] changeData(int[] data) {
        int length = 0, k = 0;
        for (int i : data) {
            if ((i % 2) != 0) {
                length++;
            }
        }
        int[] result = new int[length];
        for (int i : data) {
            if ((i % 2) != 0) {
               result[k++] = i;
            }
        }
        return result;
    }
}