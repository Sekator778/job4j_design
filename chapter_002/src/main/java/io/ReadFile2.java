package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFile2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            reader.lines().forEach(list::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String s : list
             ) {
            System.out.println(s);
        }
    }
}
