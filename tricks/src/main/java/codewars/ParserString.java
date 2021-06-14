package codewars;

public class ParserString {
    public static int[] parse(String data) {
        int value = 0;
        int i = 0;
        int[] result = new int[12];
        char[] command = data.toCharArray();
        for (char ch : command) {
            switch (ch) {
                case 'i':
                    value++;
                    break;
                case 'd':
                    value--;
                    break;
                case 's':
                    value = value * value;
                    break;
                case 'o':
                    result[i++] = value;
                    break;
            }
        }
        return result;
    }
}

