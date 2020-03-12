package ood.tdd;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneratorString2 implements Template {
    private static final Pattern KEYS = Pattern.compile("\\$\\{(\\w+)}");
//         System.out.println("Help, ${sos}, ${sos}, ${sos}".replaceAll("\\$\\{(\\w+)}", "Aa"));
    @Override
    public String generate(String template, Map<String, String> data) {
        boolean b = false;
        for (Map.Entry<String, String> pair : data.entrySet()
             ) {
            String replace = pair.getKey();
            template.replaceAll("\\$\\{()}", pair.getValue());
        }
        return null;
    }
}
