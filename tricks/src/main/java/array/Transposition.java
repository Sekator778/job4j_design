package array;

/**
 * Транспонирование матрицы, это когда строки исходной матрицы,
 * становятся столбцами в результирующей матрице
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * А еще во время транспонирования номер столбца и номер строки
 * "меняются местами". Например, было a[1][9], стало a[9][1].
 */
public class Transposition {

    public static int[][] convert(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}