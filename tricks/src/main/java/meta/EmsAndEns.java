package meta;

public class EmsAndEns {
    public static boolean isEqually(String str) {
        if (str == null) {
            return false;
        }
        if (str.length() == 0) {
            return true;
        }
        char[] in = str.toLowerCase().toCharArray();
        int m = 0, n = 0;
        for (char ch : in) {
            if (ch == 'm') {
                m++;
            } else if (ch == 'n') {
                n++;
            }
        }
        if (m == 0) {
            return true;
        }
        return m == n;
    }
}
