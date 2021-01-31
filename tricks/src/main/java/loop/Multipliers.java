package loop;

public class Multipliers {
    public static void out(int n) {
        System.out.println(metod(n));
    }

    public static String metod(int n) {
        String res = "";
        String ln = System.lineSeparator();
        for (int i = 1; i <= n; i++) {
            if (0 == (n % i)) {
                res += i + ln;
            }
        }
        res = res.substring(0, res.length() - 2);
        return res;
    }
}
