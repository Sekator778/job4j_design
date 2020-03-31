package list;

import java.util.Arrays;

/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class Test {
    public static void main(String[] args) {
        int[] mass = {1, 2};
        int size = mass.length;
        System.out.println(Arrays.toString(mass));

        for (int i = 0; i < mass.length/2; i++) {
            int temp = mass[i];
            mass[i] = mass[size - 1 - i];
            mass[size - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(mass));

    }
}
