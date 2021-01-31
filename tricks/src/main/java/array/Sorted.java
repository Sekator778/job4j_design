package array;

public class Sorted {
    public static boolean isSorted(int[] array) {
        for (int i = 0, j = 1; i < array.length - 1; i++, j++) {
            if (array[i] > array[j]) {
                return false;
            }
        }
        return true;
    }
}
