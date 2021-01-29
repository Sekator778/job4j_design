package condition;

import java.util.List;

/**
 * Всем нам известно такое понятие как високосный год - это год в котором в феврале
 * по календарю 29 дней, а не 28 как во все остальные годы. Чтобы определить является
 * ли год високосным, то он должен отвечать следующим критериям
 *
 * 1. год, номер которого кратен 400 - високосный;
 * 2. остальные годы, номер которых кратен 100 - невисокосные (1700, 1800, 1900, 2100)
 * 3. остальные годы, номер которых кратен 4 - високосные.
 *
 * Необходимо реализовать метод, который принимает целочисленное значение (номер года),
 * и на выходе вернуть булево значение - true, если год високосный и false, если год невисокосный.
 */
public class LeapYear {
    public static boolean checkYear(int year) {
        List<Integer> noLeapYear = List.of(1700, 1800, 1900, 2100);
        boolean leap = year % 400 == 0 || year % 100 == 0 || year % 4 == 0;
        if (noLeapYear.contains(year)) return false;
        return leap;
    }
}