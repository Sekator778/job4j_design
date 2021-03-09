package array;

/**
 * Метод принимает два параметра:
 *
 * 1. Целочисленное значение num;
 *
 * 2. Массив целочисленных значений ints.
 *
 * Необходимо проверить являются ли все элементы массива ints,
 * делителями числа num, если являются - то метод должен вернуть true.
 */
public class Divider {
    public static boolean check(int num, int[] ints) {
        for (int anInt : ints) {
            if ((num % anInt) != 0) {
                return false;
            }
        }
        return true;
    }
}
