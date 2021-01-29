package condition;

/**
 * Метод принимает число. Необходимо проверить у этого числа следующие условия и
 * при этом вернуть следующие результаты:
 * 1. Если число делится на 3 без остатка - метод должен вернуть строку Hello;
 * 2. Если число делится на 5 без остатка - метод должен вернуть строку World;
 * 3. Если число делится на 3 и на 5 одновременно без остатка - метод должен
 * вернуть строку Hello, World!!!
 * 4. Если не выполнится ни одно из выше указанных условий - метод должен
 * вернуть строку Operation not support.
 * <p>
 * Для решения необходимо будет написать 2 булево выражения и там где это нужно
 * объединить их правильным образом.
 */
public class HelloWorld {
    public static String checkNumber(int number) {
        boolean three = (number % 3) == 0;
        boolean five = (number % 5) == 0;
        if (three && !five) {
            return "Hello";
        } else if (five && !three) {
            return "World";
        } else if (three) {
            return "Hello, World!!!";
        } else return "Operation not support";
    }
}