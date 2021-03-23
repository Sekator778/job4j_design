package array;

/**
 * 59. Раздвинуть элементы массива
 * В данной задаче вам предстоит реализовать алгоритм сдвига элементов массива.
 * Вы должны написать метод который принимает в качестве параметров двумерный массив
 * (количество рядов должно быть равно количеству строк), массив заполнен случайными числами от 1 до 100,
 * и два индекса
 * индекс строки и индекс колонки.
 * В данную ячейку записывается 0 а все цифры левее, правее, выше и ниже сдвигаются на 1 ячейку
 * <p>
 * Например было
 * {1, 2, 3},
 * {4, 5, 6},
 * {7, 8, 9}
 * и если индексы это 1 и 1 то массив должен иметь вид
 * <p>
 * {1, 5, 3},
 * {5, 0, 5},
 * {7, 5, 9}
 */
public class PushTheNumbers {

    public static void push(int[][] array, int row, int column) {
        pushHorizontal(array, row, column);
        pushVertical(array, row, column);
        array[row][column] = 0;
    }

    private static void pushHorizontal(int[][] array, int row, int column) {
        for (int i = 0; i < array[row].length; i++) {
            if (i < column) {
                array[row][i] = array[row][i + 1];
            }
        }
        for (int i = array[row].length - 1; i >= 0; i--) {
            if (i > column) {
                array[row][i] = array[row][i - 1];
            }
        }
    }

    private static void pushVertical(int[][] array, int row, int column) {
        for (int i = 0; i < array.length; i++) {
            if (i < row) {
                array[i][column] = array[i + 1][column];
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (i > row) {
                array[i][column] = array[i - 1][column];
            }
        }
    }
}
