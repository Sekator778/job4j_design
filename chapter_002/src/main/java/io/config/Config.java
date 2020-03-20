package io.config;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            while (reader.ready()) {
                String line = reader.readLine();
                var lines = line.split("=");
                if ((line.contains("=")) && (lines.length == 2)) {
                    values.put(lines[0], lines[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        if (values.containsKey(key)) {
            return values.get(key);
        } else {
            throw new UnsupportedOperationException("Don't impl this method yet!");
        }
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
        Config config = new Config("/home/sekator/projects/job4j_design/app.properties");
        config.load();
        config.values.entrySet().forEach(System.out::println);
    }
}