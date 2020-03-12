package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexGroup {
    public static void main(String[] args) {
        String line = "aaa 1 bbbb 2 cccc";
        Pattern pattern = Pattern.compile("(1)(.*)(2)");
//        Pattern pattern = Pattern.compile("1");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
//            System.out.print(matcher.start() + " " + matcher.group() + " ");
            System.out.println(matcher.group(0));

            System.out.println(matcher.group(1));
            System.out.println(matcher.group(3));

        }
        System.out.println("1-2".replaceAll("(1)(.*)(\\d)", "$3$2$1"));
        System.out.println("Help, ${sos}, ${sos}, ${sos}".replaceAll("\\$\\{(\\w+)}", "Aa"));
        System.out.println("I am a ${name} how are you".replaceAll("\\$\\{(\\w+)}", "PedroAlvares"));
    }
}
