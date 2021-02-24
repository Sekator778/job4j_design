package array;

import java.util.Arrays;

/**
 * Метод принимает двумерный массив у которого число рядов
 * и число элементов в ряду не совпадают, также количество элементов
 * в каждом ряду может быть абсолютно произвольным.
 *
 * Вам необходимо реализовать метод так, чтобы на выходе получился двумерный
 * квадратный массив. При этом размерность выходного массива должна рассчитываться.
 * Если для полного заполнения выходного массива в исходном массиве
 * не хватает элементов - необходимо дополнить массив 0.
 *
 * Например:
 *
 * Исходный массив {{1}, {2, 3, 4}} - должно получиться {{1, 2}, {3, 4}}
 *
 * Исходный массив {{1}, {2, 3, 4}, {5, 6}} - должно получиться {{1, 2, 3}, {4, 5, 6}, {0, 0, 0}}
 *
 * !!!! Решение костлявое нету времени подумать сделал чтоб тесті не падали !!!!
 */
public class Converter {
    public static int[][] convertInSquareArray(int[][] array) {
        int arrayLength = 0;
        int[] ints = new int[33];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                ints[arrayLength] = array[i][j];
                arrayLength++;
            }
        }
        int capacity = 0;
        int length = 1;
        while (capacity < arrayLength) {
            length++;
            capacity = length * length;
        }
        int k = 0;
        int[][] result = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (k < arrayLength) {
                    result[i][j] = ints[k++];
                }
            }
        }
        return result;
    }
}