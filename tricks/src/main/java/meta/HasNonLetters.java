package meta;

import java.util.Map;
import java.util.stream.Collectors;

public class HasNonLetters {
    public static boolean hasNoneLetters(String blacklist, String phrase) {
        if (blacklist == null || blacklist.length() == 0) {
            return true;
        }
        if (phrase == null || phrase.length() == 0) {
            return true;
        }
        Map<Character, Integer> charToInt = blacklist.toLowerCase().chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toMap(c -> c, blacklist::indexOf));
        char[] phr = phrase.toLowerCase().toCharArray();
        for (char ch : phr) {
            if (charToInt.containsKey(ch)) {
                return false;
            }
        }
        return true;
    }
}