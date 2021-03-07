package array;

/**
 * Дан массив слов, необходимо получить текст из этих слов, разделенных пробелом.
 *
 * Например,
 *
 * {"one", "two", "three"} => "one two three"
 */
public class WordsToText {
    public static String convert(String[] words) {
        StringBuilder builder = new StringBuilder();
        for (String s : words) {
            builder.append(s).append(" ");
        }
        return builder.toString().strip();
    }
}
