import java.util.HashMap;

/**
 * Задан большой текст. Из него вырезают слов и предложения. Из них составляют новый текст.
 * Нужно проверить, что новый текст был получен из оригинально.
 * "(?U)\\W+" - данная конструкция позволяет делить только по словам без учета не букв
 */
public class StringMaker {
    public static boolean generateBy(String origin, String line) {
        String[] subStr = origin.split("(?U)\\W+");
        HashMap<String, Integer> input = new HashMap<>();
        for (int i = 0; i < subStr.length; i++) {
            input.put(subStr[i], i);
        }
        subStr = line.split("(?U)\\W+");
        for (String s : subStr) {
            if (!input.containsKey(s)) {
                return false;
            }
        }
        return true;
    }
}
