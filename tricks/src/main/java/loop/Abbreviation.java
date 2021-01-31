package loop;

import java.util.Locale;

/**
 * Метод принимает строку, которая состоит из нескольких слов
 * каждое из которых начинается с прописной буквы. Необходимо
 * из полученной строки сформировать аббревиатуру.
 */
public class Abbreviation {
    public static String collect(String s) {
        StringBuilder builder = new StringBuilder();
        for (String word : s.split(" ")) {
            builder.append(word.charAt(0));
        }
        return builder.toString().toUpperCase(Locale.ROOT);
    }
}
