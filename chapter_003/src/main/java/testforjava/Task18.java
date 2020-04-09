package testforjava;

/**
 * Задан двойной массив, заполненный нулями и единицами. Нужно определить самое большое множество единиц. Множеством
 * считается объединение единиц, которые соприкасаются друг с другом. Диагональное соприкосновение не учитывать.
 */

public class Task18 {
    private final int[][] masiv;

    public Task18(int[][] masiv) {
        this.masiv = masiv;
    }

    private int check() {
        int count = 0;
        int max = 0;
        for (int[] ints : masiv) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    count++;
                }
            }
            if (max < count) {
                max = count;
            }
            count = 0;
        }
        return max;
    }

    private int checkVertical() {
        int count = 0;
        int max = 0;
        for (int i = 0; i < masiv.length; i++) {
            for (int j = 0; j < masiv[i].length; j++) {
                if (masiv[j][i] == 1) {
                    count++;
                }
            }
            if (max < count) {
                max = count;
            }
            count = 0;
        }
        return max;
    }

    private int result() {
        int horizontal = check();
        int vertical = checkVertical();
        return Math.max(vertical, horizontal);
    }

    public static void main(String[] args) {
        int[][] input = {{1, 1, 1}, {0, 1, 1}, {0, 0, 0}};
        Task18 task = new Task18(input);
        System.out.println(task.result());
    }
}
