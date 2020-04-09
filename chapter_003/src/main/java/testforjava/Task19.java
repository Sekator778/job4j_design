package testforjava;

/**
 * Задан двойной массив из единиц и нулей.
 * Нужно найти минимальный путь от точки А до точки В.
 * Двигаться можно только по единицам и только в вниз или вправо.
 */

public class Task19 {
    private final int[][] masiv;


    public Task19(int[][] masiv) {
        this.masiv = masiv;
    }

    private boolean testNextVpravo(int one, int two) {
            return (masiv[one + 1][two] == 1);
    }

    private boolean testNextVniz(int one, int two) {
            return (masiv[one][two + 1] == 1);
    }

//    private List<Integer> way(int start1, int start2, int end1, int end2) {
//
//        for (int i = 0; i < masiv.length; i++) {
//            for (int j = 0; j < masiv[i].length; j++) {
//                if ()
//            }
//        }
//    }
//}
//
}
