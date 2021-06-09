package meta;

public class ArrayReverser {
    public static String[] reverse(String[] a) {
        int length = a.length;
        String[] result = new String[length];
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = a[i].length();
        }
        char[] chars = convert(a);
        int pos = 0;
        for (int i = 0; i < length; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < ints[i]; j++) {
                pos++;
                s.append(chars[chars.length - pos]);
            }
            result[i] = s.toString();
        }
        return result;
    }
    private static char[] convert(String[] words) {
        return String.join("", words)
                .toCharArray();
    }
}
