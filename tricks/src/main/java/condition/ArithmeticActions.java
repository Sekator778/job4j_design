package condition;

/**
 * Необходимо реализовать метод, который принимает 3 параметра:
 * 1. Первый аргумент арифметического действия;
 * 2. Второй аргумент арифметического действия;
 * 3. Результат применения арифметического действия к двум первым аргументам.
 * метод должен быть реализован таким образом, чтобы он вернул строковое
 * представление действия, которое выполнилось.
 * Например, первый аргумент 100, второй 200, а результат вычисления
 * 300 - значит метод должен вернуть строку "added".
 * Для разности - "subtracted", умножения - "multiplied",
 * деления - "divided". Если никакого арифметического действия
 * над исходными значениями выполнить нельзя - метод должен вернуть строку "none".
 */
public class ArithmeticActions {
    public static String selectAction(int left, int right, int rsl) {
        if ((left + right) == rsl) {
            return "added";
        } else if (((left - right) == rsl)) {
            return "subtracted";
        } else if (((left * right) == rsl)) {
            return "multiplied";
        } else if (((left / right) == rsl)) {
            return "divided";
        } else {
            return "none";
        }
    }
}