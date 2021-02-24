package array;

public class Validator {
    public static boolean checkArray(int[] data, int value) {
        int check = 0;
        for (int i : data) {
            if (i == value) {
                check++;
            }
        }
        return check < (data.length / 2);
    }
}