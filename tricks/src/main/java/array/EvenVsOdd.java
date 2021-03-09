package array;

/**
 * Вам даны очки игроков.
 * Игроки разделись таким образом,
 * что под четными индексами находятся очки первой команды,
 * под нечетными второй. Ваша задача определить, кто выиграл.
 * Выигрывает та команда, которая набрала наибольшее число очков.
 * Если выиграла первая команда, то нужно вернуть 1, если вторая, то 2,
 * если ничья то 0.
 */
public class EvenVsOdd {
    public static int whoWin(int[] players) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < players.length - 1; i = i + 2) {
            if (players[i] > players[i + 1]) {
                even = even + players[i] - players[i + 1];
            } else {
                odd = odd + players[i + 1] - players[i];
            }
        }
        if (even > odd) {
            return 1;
        } else if (even == odd) {
            return 0;
        } else {
            return 2;
        }
    }
}
