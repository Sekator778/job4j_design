package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> result = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            Pattern p = Pattern.compile("\\b(404)\\b");
            while (fileReader.ready()) {
                String s = fileReader.readLine();
                var s1 = s.split(" ");
                Matcher m = p.matcher(s1[s1.length - 2]);
                while (m.find()) {
                    result.add(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        log.forEach(System.out::println);
    }
}