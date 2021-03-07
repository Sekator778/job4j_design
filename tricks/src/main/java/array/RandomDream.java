package array;

/**
 * Дан массив призов и положительное число, которое сгенерировано случайно. Ваша задача получить приз
 * <p>
 * Например,
 * <p>
 * {"автомобиль", "квартира", "билет"} и число = 1 => "автомобиль"
 * <p>
 * {"автомобиль", "квартира", "билет"} и число = 2 => "квартира"
 * <p>
 * {"автомобиль", "квартира", "билет"} и число = 4 => "квартира"
 * <p>
 * {"автомобиль", "квартира", "билет"} и число = 99 => "билет"
 */
public class RandomDream {
    public static String random(String[] prizes, int num) {
        String answer = null;
        int count = 1;
        do {
            for (String prize : prizes) {
                if (count++ == num) {
                    answer = prize;
                    break;
                }
            }
        }
        while (answer == null);
        return answer;
    }
}