package test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */

public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Joan");

        map.computeIfPresent("name1", (key, value) -> "what" + ", " + "Fuck");

        System.out.println(map.get("name")); //output: name, Joan
    }
}
