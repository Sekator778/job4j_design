package array;

/**
 * Метод принимает массив целочисленных значений.
 * При этом массив может содержать как положительные значения, так и отрицательные,
 * но не может содержать 0.
 *
 * Необходимо реализовать метод таким образом, чтобы он вернул булево значение следующим образом:
 *
 * 1. true - количество отрицательных значений в массиве нечетное число;
 *
 * 2. false - количество положительных значений в массиве четное число.
 */
public class PositiveOrNegative {
    public static boolean check(int[] data) {
        int negative = 0, positive = 0;
        for (int datum : data) {
            if (datum < 0) {
                negative++;
            } else {
                positive++;
            }
        }
        if ((negative % 2) != 0) {
            return true;
        } else if ((positive % 2) == 0) {
            return false;
        }
        throw new IllegalArgumentException("ZERO");
    }
}