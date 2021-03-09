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
    public static void main(String[] args) {
        int[][] data = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[] result = new int[10];
        System.out.println(Arrays.toString(result));
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if ((j + i) == 1) {
                    System.arraycopy(data[i], 0, result, 0, data[i].length);
                }
            }
        }
        System.out.println(Arrays.toString(result));
    }
    public static int[][] cloneArray(int[][] src) {
        int length = src.length;
        int[][] target = new int[length][src[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(src[i], 0, target[i], 0, src[i].length);
        }
        return target;
    }
    public static int[] collectNewArray(int[][] data, int sum) {
        var result = new int[67];
        var res = new int[100];
        int k = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if ((i + j) == sum) {
                    System.out.println();
                } else {
                    res = Arrays.copyOf(data[i], j);
                    result[k++] = data[i][j];
                }
            }
        }
        return res;
    }
}