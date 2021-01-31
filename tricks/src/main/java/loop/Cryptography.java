package loop;

/**
 * Необходимо реализовать метод, который принимает строку, которую необходимо зашифровать
 * таким образом, чтобы на выходе отражались только 4 последних элемента, все остальные
 * были заменены на #. При этом соблюсти условия:
 * <p>
 * 1. Если входная строка пустая - необходимо вернуть строку "empty";
 * <p>
 * 2. Если входная строка содержит больше 0 и не более 4 символов - метод должен
 * вернуть исходную строку.
 */
public class Cryptography {

    public static String code(String s) {
        int length = s.length();
        if (s.isEmpty()) {
            return "empty";
        }
        if (length < 4) {
            return s;
        }
        StringBuilder builder = new StringBuilder(12);
        for (int i = 0; i < length; i++) {
            if (i < (length - 4)) {
                builder.append("#");
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
}
