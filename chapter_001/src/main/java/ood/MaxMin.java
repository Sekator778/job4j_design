package ood;

import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;

/**
 * находим миним максимальный елемент в листе по условию
 * которое передаем в компараторе (любое)
 * для DRY нам нужно вынести повторяющийся код
 * тут возникает потребность в передачи некого условия
 * это мы реализуем когда передаем предикат
 * x -> x < 0 предикат тестирует условие это и дает нам булен тру )
 * если компаратор дал меньше 0
 *
 * п.с. пишу для себя в целях учебных если что то понимаю не так отпишите %)
 * задание прикольное но долго мучался как в предикат запихнуть условие
 * но там очень просто пишеш что хочеш чтоб проверяли на булен
 * короче условие
 * 11.03.2020
 */
public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findMinMax(value, comparator, a -> a < 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findMinMax(value, comparator, a -> a > 0);
    }

    /**
     *
     * @param value - лист с данными
     * @param comparator - просто компаратор
     * @param predicate - условие для теста
     * @param <T> - это вроде дженерик короче обобщенный тип
     * @return - искомое
     */
    private <T> T findMinMax(List<T> value, Comparator<T> comparator, IntPredicate predicate) {
        T tmp = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            if (predicate.test(comparator.compare(tmp, value.get(i)))) {
                tmp = value.get(i);
            }
        }
        return tmp;
    }
}