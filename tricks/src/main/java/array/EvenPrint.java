package array;

/**
 * Дан целочисленный массив размера N.
 * Вывести все содержащиеся в данном массиве четные числа
 * в порядке убывания их индексов. Для вывода использовать System.out.println()
 * <p>
 * Например, для {1, 2, 3, 4} вывести 4, 2
 */
public class EvenPrint {
    public static void print(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if ((array[i] % 2) == 0) {
                System.out.println(array[i]);
            }
        }
    }
}
