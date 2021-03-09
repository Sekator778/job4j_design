package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Назовем аномалиями диапазоны индексов,
 * на которых значения массива меньше или равно down или больше или равно up.
 * Ваша задача найти все аномалии в массиве. Если в аномалии одно,
 * число то нужно вернуть диапазон [i, i] - где i индекс числа выходящего за границы.
 * Например,
 * {5, 10, 15}, up = 16, down = 4 => аномалий нет
 * {5, 4, 15}, up = 16, down = 4 => {{1, 1}}
 * {5, 4, 3, 15}, up = 16, down = 4 => {{1, 2}}
 * {5, 10, 15, 1, 2}, up = 16, down = 4 => {{3, 4}}
 *
 * ПРОБЛЕМА удаление из масива масив null !!!!!!!!!!
 */
public class Anomaly {
    public static int[][] found(int[] data, int up, int down) {
        int[][] result = new int[data.length][];
        int count = 0;
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if ((data[i] <= down) || (data[i] >= up)) {
                index.add(i);
            }
        }
        for (int i = 0; i < index.size(); i++) {
            if (i == index.size() - 1) {
                result[count++] = new int[]{index.get(i), index.get(i)};
            } else {
                result[count++] = new int[]{index.get(i), index.get(i + 1)};
                i++;
            }
        }
        // здесь это делаем -----------------------
        int l = 0;
        for (int[] ints : result) {
            if (ints != null) {
                l++;
            }
        }
        int[][] res = new int[l][];
        if (l >= 0) {
            System.arraycopy(result, 0, res, 0, l);
        }
        return res;
    }
}