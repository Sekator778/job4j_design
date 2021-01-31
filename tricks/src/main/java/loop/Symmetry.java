package loop;

/**
 * Метод принимает целочисленное значение. Необходимо проверить
 * является ли оно симметричным или нет. Симметричным считается
 * число которое в котором числа идущие по порядку в прямом и
 * обратном порядке равны друг другу.
 */
public class Symmetry {
    public static boolean check(int i) {
        String string = String.valueOf(i);
        int length = string.length();
        if ((length % 2) == 0) {
            return false;
        }
        int ends = length - 1;
        for (int j = 0; j < length / 2; j++) {
            if (string.charAt(j) != string.charAt(ends)) {
                return false;
            }
            ends--;
        }
        return true;
    }
}
