package array;


import java.util.Arrays;

/**
 * Необходимо реализовать метод который вернет одномерный массив,
 * который не будет содержать значений 0 (необходимо использовать метод Arrays.copyOf()).
 * При этом исходные данными будут следующими:
 *
 * 1. Квадратный двумерный массив целочисленных значений data.
 * 2. Целочисленный элемент sum, который означает сумму индексов в массиве.
 * При этом необходимо чтобы выполнились следующие условия:
 * 1. Если сумма индексов при переборе двумерного массива равна sum,
 * то элемент с такими индексами должен принять значение 0.
 * 2. Выходной одномерный массив не должен содержать значения 0.
 */
public class CheckSumIndexes {
    public static int[] collectNewArray(int[][] data, int sum) {
        int [] result = new int[67];
        int [] res = new int[100];
        int k = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if ((i + j) == sum) {
                } else {
                    res = Arrays.copyOf(data[i], j);
                    result[k++] = data[i][j];
                }
            }
        }
        return res;
    }
}