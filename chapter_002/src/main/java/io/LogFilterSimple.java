package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilterSimple {
    public static List<String> filter(String file) {
        List<String> result = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            while (fileReader.ready()) {
                String string = fileReader.readLine();
                var strings = string.split(" ");
                if (strings[strings.length - 2].contains("404")) {
                    result.add(string);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void save(List<String> list, String outFile) {
        try (PrintWriter writer = new PrintWriter(new BufferedOutputStream(
                new FileOutputStream(outFile)
        ))) {
            list.forEach(writer::write);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        log.forEach(System.out::println);
        save(log, "404.txt");
    }
}