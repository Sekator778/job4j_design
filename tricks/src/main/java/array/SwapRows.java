package array;

public class SwapRows {
    public static void swap(int[][] data, int src, int dst) {
        int tmp;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (i == src) {
                    tmp = data[i][j];
                    data[i][j] = data[dst][j];
                    data[dst][j] = tmp;
                }
            }
        }
    }
}