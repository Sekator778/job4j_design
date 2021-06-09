package meta;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestWord {
    public static int findLongest(String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return 0;
        }
        List<String> strings = Arrays.asList(sentence.split(" "));
        String biggestWord = Collections.max(strings, Comparator.comparing(String::length));
        return biggestWord.length();
    }
}
