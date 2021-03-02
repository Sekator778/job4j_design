package array;

/**
 * Дан массив из трех элементов. В нем записаны соответственно
 * Фамилия Имя Отчество. Ваша задача получить инициалы.
 * <p>
 * Например,
 * <p>
 * "Иванов", "Роман", "Иваныч" -> "Иванов Р.И."
 */
public class Initials {
    public static String convert(String[] fio) {
        char[] ch = new char[2];
        String family = fio[0];
        ch[0] = fio[1].charAt(0);
        ch[1] = fio[2].charAt(0);
        family = family + " " + ch[0] + "." + ch[1] + ".";
        return family;
    }
}
