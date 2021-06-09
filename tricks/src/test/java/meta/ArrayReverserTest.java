package meta;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayReverserTest {
    public static void main(String[] args) {
        String[] in = new String[]{"Don't", "worry", ",", "be", "happy", "!"};
        String[] expect = new String[]{"!yppa", "heb,y", "r", "ro", "wt'no", "D"};

        String[] result = ArrayReverser.reverse(in);
        System.out.println(Arrays.toString(result));

        System.out.println(Arrays.equals(expect, result));
    }

}