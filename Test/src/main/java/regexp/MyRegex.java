package regexp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRegex {
    public static void main(String[] args) {
//        int start = 0;
//        int end = 0;
//        String input = "Jack is a boy";
//        String replaced = "123";
//        int k = replaced.length() - 1;
//
//
//        StringBuilder builder = new StringBuilder(input);
//
//        Pattern p = Pattern.compile("a");
//        Matcher m = p.matcher(input);
//        while(m.find()) {
//            start = m.start();
//           end =  m.end();
//            System.out.print("Start " + start + " " );
//            System.out.print("End " + end + " " );
//            builder.replace(start, end, replaced);
//
//
//        }
//        System.out.println("");
//        System.out.println(builder);
//        Pattern pattern  = Pattern.compile("Здесь будет регулярное выражение");
//        Matcher matcher = pattern.matcher(",eltn");
//        String result = matcher.replaceAll("/");
//        System.out.println(result);
//

        Map<String, String> map = new HashMap<>();
        map.put("key", "Petr");
        map.put("two", "Olya");

        String input = "I am a key, Who are two?";
        String key = "";
        String value = "";
        String result = "";

        for (Map.Entry<String, String> pair : map.entrySet()) {
            result = input.replaceAll(pair.getKey(), pair.getValue());
        }
        System.out.println(result);
    }
}
