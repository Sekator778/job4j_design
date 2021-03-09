package array;

import java.util.Arrays;

/**
 * В классе String есть метод split(), этот метод делит строки на части по разделителю.
 * Ваша задача написать его аналог
 * <p>
 * Например (запись идет через строки для удобства)
 * <p>
 * "1 2", ' ' => {"1", "2"}
 * <p>
 * "12", ' ' => {"12"}
 */
public class Split {
    public static char[][] split(char[] str, char c) {
        int k = 0;
        int delimiter = 0;
        char[][] result = new char[str.length][];
        for (int i = 0; i < str.length; i++) {
            if (str[i] == c) {
                result[k++] = Arrays.copyOfRange(str, delimiter, i);
                delimiter = i + 1;
            }
        }
        result[k] = Arrays.copyOfRange(str, delimiter, str.length);
        int l = 0;
        for (char[] chars : result) {
            if (chars != null) {
                l++;
            }
        }
        char[][] res = new char[l][];
        if (l >= 0) {
            System.arraycopy(result, 0, res, 0, l);
        }
        return res;
    }
}
