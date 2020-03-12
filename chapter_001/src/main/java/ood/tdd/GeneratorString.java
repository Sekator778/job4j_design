package ood.tdd;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * заменяем в строке по регулярке ${(xxxxxxxx)}
 *
 * На позиции 0 будет всё совпадение целиком.
 * На позиции 1 – содержимое первой скобочной группы.
 * На позиции 2 – содержимое второй скобочной группы.
 * …и так далее…
 * где (xxxxx) - ключ мапы причем это 1я група
 * вместо этого вхождения ставим значение с мапы по ключу
 */
public class GeneratorString implements Template {
    private static final Pattern KEYS = Pattern.compile("\\$\\{(\\w+)}");

    /**
     * @param template - стринг для замены
     * @param data - мапа с ключами и данними для замены
     * @return стригбилдер что налепили с мапы по ключам
     */
    @Override
    public String generate(String template, Map<String, String> data) {
        Matcher matcher = KEYS.matcher(template);
        StringBuilder builder = new StringBuilder(template);
        boolean b = false;
        int start, end;
        int sizeReplace = 0;
        while (matcher.find()) {
            b = true;
            start = matcher.start() + sizeReplace;
            end = matcher.end() + sizeReplace;
            String valueForReplace = matcher.group();
            String firstGroup = matcher.group(1);

            if (!data.containsKey(firstGroup)) {
                throw new IllegalArgumentException("Map not contains this key: " + firstGroup);
            }
            String valueForAdd = data.get(firstGroup);
            builder.replace(start, end, valueForAdd);
            sizeReplace += valueForAdd.length() - valueForReplace.length();
        }
        if (!b) {
            throw new IllegalArgumentException("The String not have key" + template);
        }
        return builder.toString();
    }
}
