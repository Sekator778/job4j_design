package array;

/**
 * Вам необходимо определить общий размер массива при их объединении
 */
public class ConcatArray {
    public static int combineSize(int[] a, int[] b) {
        return a.length + b.length;
    }

    public static int getMaxValue(int[] array) {
        return Math.max(array[0], array[array.length - 1]);
    }
}
