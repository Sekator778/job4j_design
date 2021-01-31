package loop;

/**
 * Вам даны два целых положительных числа числа n и d (d > 0). n это делимое,
 * d это делитель. Вам нужно не используя операцию %, найти остаток от деления.
 */
public class ModWithLoop {
    public static int mod(int n, int d) {
        while (n >= d) {
            n = n - d;
        }
        return n;
    }
}
