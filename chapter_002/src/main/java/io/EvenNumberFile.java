package io;

import java.io.*;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader("even.txt"))
                ) {
            String text;
            while ((text = reader.readLine()) != null) {
                int b = Integer.parseInt(text);
                if ((b % 2) == 0) {
                    System.out.println(b + " even number");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
