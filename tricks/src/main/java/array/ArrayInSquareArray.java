package array;

public class ArrayInSquareArray {
    public static int[][] convertArray(int[] array) {
        int arrayLength = array.length;
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
                if (k < array.length) {
                    result[i][j] = array[k++];
                }
            }
        }
        return result;
    }
}