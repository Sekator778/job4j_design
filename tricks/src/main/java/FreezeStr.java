import java.util.HashMap;
import java.util.Map;

/**
 * Даны две строки. Нужно проверить, что вторая строка получилась методом перестановок символов в первой строке.
 *
 * п.с. считаю код не оптимален
 */
public class FreezeStr {
    public static boolean eq(String left, String right) {
        char[] input = left.toCharArray();
        char[] check = right.toCharArray();
        HashMap<Character, Integer> inputMap = new HashMap<>();
        HashMap<Character, Integer> checkMap = new HashMap<>();
        for (char ch : input
        ) {
            if (inputMap.containsKey(ch)) {
                inputMap.put(ch, inputMap.get(ch) + 1);
            } else {
                inputMap.put(ch, 1);
            }
        }
        for (char ch : check
        ) {
            if (checkMap.containsKey(ch)) {
                checkMap.put(ch, checkMap.get(ch) + 1);
            } else {
                checkMap.put(ch, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : inputMap.entrySet()
        ) {
            Character ch = entry.getKey();
            if (checkMap.containsKey(ch)) {
                if (!(checkMap.get(ch).equals(entry.getValue()))) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}


//=========
//
//        for (char ch :
//                check) {
//            if (inputMap.containsKey(ch)) {
//                inputMap.put(ch, inputMap.get(ch) - 1);
//            } else {
//                return false;
//            }
//        }
//        int sum = 0;
//        for (Integer i : inputMap.values()) {
//            sum += i;
//        }
//        return sum == 0;