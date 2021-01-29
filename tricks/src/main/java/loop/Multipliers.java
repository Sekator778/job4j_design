package loop;

public class Multipliers {
    public static void main(String[] args) {
        String s = "123";
        s = s.substring(0, s.length() - 1);
        System.out.println(s);
    }
    public static void out(int n) {
        System.out.println(metod(n));
    }
    public static String metod(int n)
    {
        String res = "";
        for (int i = 1; i <= n; i++)
        {
            if(0 == (n % i))
                res += i+ "\n";
        }
        res = res.substring(0, res.length() - 1);
        return res;
    }
}