package array;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Множество - это набор уникальных элементов.
 * Пересечение множеств - это такая операция,
 * когда в результирующее множество попадают только элементы,
 * которые есть в обоих множествах. Если нет такие элементов, то результат пустое множество.
 * <p>
 * Ваша задача реализовать данную операцию в коде. Множества заданы массивами
 * <p>
 * Например,
 * <p>
 * {1, 2} и {3, 4} => {}, нет общих элементов
 * <p>
 * {1, 2} и {1, 3, 4} => {1}, 1 общий элемент
 * <p>
 * {1, 2} и {1, 2, 3, 4} => {1, 2}, 1 и 2 общие элементы
 * !!!!!!!!!! как то мутно !!!!!!!!!!!!!!!!!
 */
public class AndArray {
    public static int[] and(int[] left, int[] right) {
        StringBuilder result = new StringBuilder();
        for (int l : left) {
            for (int r : right) {
                if (l == r) {
                    result.append(l);
                }
            }
        }
        char[] chars = result.toString().toCharArray();
        int i = 0;
        int[] ints = new int[chars.length];
        for (char ch : chars) {
            ints[i++] = Integer.parseInt(String.valueOf(ch));
        }
        return ints;
    }
}