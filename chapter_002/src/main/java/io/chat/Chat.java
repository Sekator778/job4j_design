package io.chat;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Chat {
    public static void main(String[] args) {
        final String STOP = "stop";
        final String GO = "go";
        String start = "Start chat \n stop - for stop chat;\n go - for continuation chat";
        boolean stop = true;

        Scanner scanner = new Scanner(System.in);
        try (PrintWriter writer = new PrintWriter(new BufferedOutputStream(
                new FileOutputStream("chatLog.txt")))) {
            System.out.println(start);
            writer.write(start + "\n");
            String question = scanner.nextLine();

            while (!(question.equalsIgnoreCase("exit"))) {
                writer.write("Q:" + question + "\n");
                if (STOP.equals(question)) {
                    stop = false;
                } else if (GO.equals(question)) {
                    stop = true;
                }
                if ((stop) && !question.isEmpty()) {
                    String answer = Answer.chatAnswer();
                    System.out.println(answer);
                    writer.write("A:" + answer + "\n");
                }
                question = scanner.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}