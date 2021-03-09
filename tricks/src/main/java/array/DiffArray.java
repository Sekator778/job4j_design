package array;


import java.util.ArrayList;
import java.util.List;

/**
 * Разность множеств это операция при которой в результирующее
 * множество попадают элементы из первого множества, но только если их нет во втором множестве.
 * <p>
 * Ваша задача реализовать эту операцию в коде. Множества заданы в виде массивов
 * <p>
 * Например,
 * <p>
 * {1}, {2} => {1}
 * {1}, {1} => {}
 * {1, 2}, {2} => {1}
 * {1}, {} => {1}
 */
public class DiffArray {
    public static int[] diff(int[] left, int[] right) {
        if (right.length == 0) {
            return left;
        }
        List<Integer> list = new ArrayList<>();
        for (int i : left) {
            for (int i1 : right) {
                if (!(i == i1)) {
                    list.add(i);
                }
            }
        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
