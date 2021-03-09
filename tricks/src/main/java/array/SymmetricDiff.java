package array;

import java.util.*;

/**
 * Симметрическая разность - это такая операция,
 * когда в результирующее множество попадают все элементы
 * из обоих множеств, кроме тех, которые есть и в том и в другом множествах.
 * <p>
 * Ваша задача реализовать эту операцию. Множества заданы в виде массивов.
 * Например,
 * <p>
 * {1}, {2} => {1, 2}
 * <p>
 * {1, 2}, {2, 3} => {1, 3}
 * <p>
 * {1}, {} => {1}
 */
public class SymmetricDiff {
    public static int[] diff(int[] left, int[] right) {
        Set<Integer> newSet = new HashSet<>();
        for (int i : left) {
            newSet.add(i);
        }
        Set<Integer> oldSet = new HashSet<>();
        for (int i : right) {
            oldSet.add(i);
        }
        for (Integer key : oldSet) {
            if (newSet.contains(key)) {
                newSet.remove(key);
            } else {
                newSet.add(key);
            }
        }
        return newSet.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}