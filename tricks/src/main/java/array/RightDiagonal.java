package array;

public class RightDiagonal {
    public static int[] diagonal(int[][] data) {
        int[] result = new int[data.length];
        int index = 0;
        int pos = data.length - 1;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if ((i + j == pos)) {
                    result[index++] = data[i][j];
                }
            }
        }
        return result;
    }
}
