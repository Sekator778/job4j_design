package myio;

import java.io.OutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class CalendarDemo {
    public static void main(String[] args) {
        String[] month = {
                "JAn", "Feb", "March", "Мау", "Sep", "Jun", "Oct", "Mar", "Jul", "Nov", "Apr", "Dec"};
        Calendar calendar = Calendar.getInstance();
        System.out.println("Date: ");
        System.out.print(month[calendar.get(Calendar.MONTH)]);
        System.out.print(" :  " + calendar.get(Calendar.DATE));
        System.out.print(" : " + calendar.get(Calendar.YEAR) + "\n");
        System.out.println("Time: ");
        System.out.print(calendar.get(Calendar.HOUR) + " : " + Calendar.MINUTE + " : " + Calendar.SECOND);
        // set Date and Time
        System.out.println();
        System.out.println(calendar.get(Calendar.YEAR));
        Calendar calendar1 = Calendar.getInstance();
        calendar.set(Calendar.DATE, 10);
        calendar1.set(Calendar.DATE, 15);
        long x = calendar1.get(Calendar.DATE) - calendar.get(Calendar.DATE);
        System.out.println("x: " + x);
        System.out.println(calendar.before(calendar1));
        System.out.println("======gregorianCalendar++++++++++++");
        GregorianCalendar gcalendar = new GregorianCalendar();
        System.out.println(gcalendar.get(Calendar.DATE) + ":" + gcalendar.get(Calendar.MONTH) + ":" + gcalendar.get(Calendar.YEAR));
        System.out.println("===========rando,+++++++++++++");
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextBoolean());
            System.out.println(random.nextInt(6));
        }
    }
}
