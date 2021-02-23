package array;

public class UpperCase {
    public static char[] toUpperCase(char[] string) {
        char[] result = new char[string.length];
        int i = 0;
        for (char ch : string) {
            if (Character.isAlphabetic(ch)) {
                result[i++] = Character.toUpperCase(ch);
            } else {
                result[i++] = ch;
            }
        }
        return result;
    }
}
