package list;

import java.util.List;

public class CheckerAhdGetter {
    public static String getElement(List<String> list) {
        return list.isEmpty() ? "" : list.get(0);
    }
}