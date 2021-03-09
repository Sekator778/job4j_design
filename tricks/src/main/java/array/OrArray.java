package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Объединение множеств это такая операция при которой в результирующее
 * множество попадают элементы, которые есть хотя бы в одном множестве.
 * Ваша задача реализовать эту операцию. Множества заданы в виде массива
 * Например,
 * {1}, {2} => {1, 2}
 * {1, 2}, {2} => {1, 2}
 * {1, 2}, {3} => {1, 2, 3}
 * {1}, {} => {1}
 */
public class OrArray {
    public static int[] or(int[] left, int[] right) {
        Set<Integer> set = new HashSet<>();
        for (int i : left) {
            set.add(i);
        }
        for (int i : right) {
            set.add(i);
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (Integer integer : set) {
            result[i++] = integer;
        }
        return result;
    }
}
