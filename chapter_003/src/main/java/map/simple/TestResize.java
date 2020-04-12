package map.simple;

/**
 *
 */

public class TestResize {
    public static void main(String[] args) throws InterruptedException {
        int size = 16;
        int capacity = 0;
        float defaultLoadFactor = 0.75f;
         float loadFactor;
        int threshold;
//loadFactor — Коэффициент загрузки. Значение по умолчанию 0.75 является хорошим компромиссом между временем доступа и объемом хранимых данных;
//threshold — Предельное количество элементов, при достижении которого, размер хэш-таблицы увеличивается вдвое. Рассчитывается по формуле (capacity * loadFactor);
//size — Количество элементов HashMap-а;
        System.out.println("будем помещать елементы и расширять с помощью threshold");

        int[] masiv = new int[size];
        int defaultThreshold = (int) (size * defaultLoadFactor);
        System.out.println("defaultThreshold " + defaultThreshold);

        for (int i = 0; i < 20; i++) {
            masiv[i] = i;
            capacity++;
            loadFactor = (float) capacity / size;
            threshold = (int) (capacity * loadFactor);
            System.out.println("count " + capacity + " threshold " + threshold);
            if (defaultThreshold < threshold) {
                System.out.println("--- pik i have resize ---");
                Thread.sleep(4000);
                int newSize = size * 2;
                int[] oldMasiv = masiv;
                masiv = new int[newSize];
                for (int j = 0; j < oldMasiv.length; j++) {
                    masiv[j] = oldMasiv[j];
                }
                size = newSize;
            }
        }
        System.out.println("будем помещать елементы и расширять с помощью loadFactor");
        size = 16;
        int[] masiv2 = new int[size];
        capacity = 0;

        for (int i = 0; i < 20; i++) {
            masiv2[i] = i;
            capacity++;
            loadFactor = (float) capacity / size;
            System.out.println("count " + capacity + " loadFactor " + loadFactor);

            if (defaultLoadFactor < loadFactor) {
                System.out.println("--- pik i have resize ---");
                Thread.sleep(4000);
                int newSize = size * 2;
                int[] oldMasiv = masiv;
                masiv2 = new int[newSize];
                for (int j = 0; j < oldMasiv.length; j++) {
                    masiv[j] = oldMasiv[j];
                }
                size = newSize;
            }
        }
    }
}
