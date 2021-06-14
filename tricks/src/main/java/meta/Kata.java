package meta;

public class Kata {
    public static void main(String[] args) {
        int number = 3;
        System.out.println(Math.sqrt(number));
    }
    public static boolean solution(String str, String ending) {
        for (int i = ending.length(); i >= 0; i--) {
            if (!(ending.charAt(i) == str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
}