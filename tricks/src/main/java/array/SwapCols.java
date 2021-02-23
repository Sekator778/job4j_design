package array;

/**
 * Ваша задача переставить два столбца в квадратной матрице. src, dest это индексы столбцов
 */
public class SwapCols {
    public static void swap(int[][] data, int src, int dst) {
        int tmp;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (j == src) {
                    tmp = data[i][j];
                    data[i][j] = data[i][dst];
                    data[i][dst] = tmp;
                }
            }
        }
    }
}
