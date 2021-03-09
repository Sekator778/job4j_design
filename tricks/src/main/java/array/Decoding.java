package array;

/**
 * Нам необходимо зашифровать данные(массив целочисленных значений)
 * поместив закодированные в результирующий массив целочисленных значений.
 * При этом метод принимает 2 параметра:
 *
 * 1. Исходный массив целочисленных значений;
 *
 * 2. Число на кратность которому мы будем проверять каждое значение в массиве.
 *
 * При этом в результирующий массив должен быть помещен остаток от деления
 * каждого элемента массива на второй аргумент реализуемого метода.
 */
public class Decoding {
    public static int[] decode(int[] ints, int number) {
        int[] res = new int[ints.length];
        for (int i = 0; i < ints.length; i++) {
            res[i] = ints[i] % number;
        }
        return res;
    }
}