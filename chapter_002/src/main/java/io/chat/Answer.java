package io.chat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Answer {
    public static String chatAnswer() {
        Random random = new Random();
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {
            reader.lines().forEach(list::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int bound = list.size();
        int rnd = random.nextInt(bound);
        return list.get(rnd);
    }
}
