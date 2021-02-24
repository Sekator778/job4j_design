package array;

/**
 * Метод принимает массив целочисленных значений.
 * Метод должен определить сумму всех элементов в массиве,
 * проверить значение суммы является ли оно четным числом.
 */
public class EvenSumElements {
    public static boolean checkArray(int[] data) {
        int sum = 0;
        for (int i : data) {
            sum = sum + i;
        }
        return (sum % 2) == 0;
    }
}
