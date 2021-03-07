package array;

import java.util.Arrays;

/**
 * Представьте, что вы связист на войне.
 * Вы отловили сигнал противника, ваша задача испортить его.
 * Вы решили это сделать следующим образом, заменить первые 5 символов 0, а последние 5 символов 1.
 * Длина исходной последовательности >= 10
 */
public class DestroySequence {
    public static char[] destroy(char[] seq) {
        for (int i = 0; i < seq.length; i++) {
            if (i < 5) {
                seq[i] = '0';
            } else if (i >= seq.length - 5) {
                seq[i] = '1';
            }
        }
        return seq;
    }
}
