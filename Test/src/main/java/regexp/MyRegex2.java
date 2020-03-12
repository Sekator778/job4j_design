package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;


public class MyRegex2 {

    static void processString(String line) {
        Pattern p = Pattern.compile("(1\\%?|2|3|4)"); // 5 Вариантов паттернов для теста
        Matcher m = p.matcher(line);          // Естественно в реальной задаче намного больше

        HashMap<String, String> map = new HashMap<>();

        int i = 0;
        while (m.find()) {
            // Здесь я ожидаю 5 итераций для каждого вхождения 1, 1%, 2, 3, 4 и замены их на ААА1, ААА1%, ААА2 и т.д.
            // Эти вхождения добавить в HashMap (map) ниже
            i++;
            System.out.println("Нужно заменить " + m.group() + " на AAA" + i);
            // Добавить $1 в хэшмап !!
            // map.put(?)
            // То есть если я передаю все 5 паттернов, то в map должно быть 5 записей
            line = m.replaceAll("AAA$1");
        }

        System.out.println("\n\n" + line);
    }

    public static void main(String[] args) {
        processString(" 1  2  3  4  4  2  1%  1%  1  2  3 ");
    }
}



