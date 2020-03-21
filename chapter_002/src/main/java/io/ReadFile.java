package io;

import java.io.FileInputStream;
import java.util.Arrays;

public class ReadFile {
    public static void main(String[] args) {
        String[] lines = new String[256];
        try (FileInputStream in = new FileInputStream("input.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
                lines = text.toString().split(System.lineSeparator());
            }
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("=================");
        for (String s : lines
             ) {
            System.out.println(s);
        }
//        Arrays.stream(lines).forEach(System.out::println);
    }
}