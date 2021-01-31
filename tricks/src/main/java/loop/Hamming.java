package loop;

/**
 * Расстояние Хэмминга - это число позиций в которых соответствующие
 * символы двух слов одинаковой длины различны.
 *
 * Например, сравнивая "101010111" и "111010100" мы должны получить - 3,
 * поскольку не равны символы (отмечены красными) - "101010111" и "111010100"
 *
 * Метод принимает 2 строки, всегда одинаковой длины. Необходимо определить
 * для строки расстояние Хэмминга. Для этого в цикле последовательно необходимо
 * сравнивать символы в строке. Для извлечения символа из строки используйте
 * метод charAt(int index) класса String.
 */
public class Hamming {
    public static int checkStrings(String left, String right) {
        int length = left.length(), sum = 0;
        if (length != right.length()) {
            throw new IllegalArgumentException("different strings");
        }
        length--;
        while (length >= 0) {
            if (left.charAt(length) != right.charAt(length)) {
                sum++;
                length--;
            } else {
                length--;
            }
        }
        return sum;
    }
}