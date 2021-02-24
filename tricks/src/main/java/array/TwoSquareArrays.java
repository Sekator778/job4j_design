package array;

/**
 * Метод принимает 2 двумерных квадратных массива.Вам необходимо реализовать
 * метод который осуществит конвертацию двумерного массива в одномерный,
 * при этом необходимо выполнить условия: при переборе двумерных массивов
 * осуществить сравнение элементов, которые стоят на местах с одинаковыми индексами,
 * и вернуть максимальное из сравниваемых значений. Максимальное из двух значений
 * необходимо вставить в результирующий массив.
 */
public class TwoSquareArrays {
    public static int[] collectArray(int[][] left, int[][] right) {
        int[] result = new int[left.length * right[0].length];
        int k = 0;
        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < left[i].length; j++) {
                result[k++] = Math.max(left[i][j], right[i][j]);
            }
        }
        return result;
    }
}