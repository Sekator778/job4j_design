package testforjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Реализован банкомат размена денег. Автомат принимает бумажную купюру
 * и обменивает на монеты. Метод должен возвращать список всех возможных вариантов размены купюры.
 */

public class Task17 {

    private final int[] values;

    public Task17(final int[] values) {
        this.values = values;
        Arrays.sort(this.values);
    }

    /**
     *
     * @param note бумажная купюра в центах
     * @return лист вариантов
     */
    public List<List<Integer>> exchange(int note) {
        return exchange(note, this.values[this.values.length - 1]);
    }

    private List<List<Integer>> exchange(int note, int maxCoin) {
        List<List<Integer>> result = new ArrayList<>();
        if (note == 0) {
            result.add(new ArrayList<>());
        } else {
            for (int i = this.values.length - 1; i >= 0; i--) {
                int coin = values[i];
                if (coin > note || coin > maxCoin) {
                    continue;
                }
                for (List<Integer> remain : exchange(note - coin, coin)) {
                    List<Integer> set = new ArrayList<>();
                    set.add(coin);
                    set.addAll(remain);
                    result.add(set);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] coins = {5, 10, 15};
        Task17 task = new Task17(coins);
        int count = 0;
        List<List<Integer>> result = task.exchange(500);
        for (List<Integer> list : result
        ) {
            System.out.println("variant " + count++);
            for (Integer i : list
            ) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

