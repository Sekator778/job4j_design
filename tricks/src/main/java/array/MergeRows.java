package array;

public class MergeRows {
    public static int[] merge(int[][] data) {
        int[] result = new int[data.length * data[0].length];
        int index = 0;
        for (int[] datum : data) {
            for (int i : datum) {
                result[index++] = i;
            }
        }
        return result;
    }
}
