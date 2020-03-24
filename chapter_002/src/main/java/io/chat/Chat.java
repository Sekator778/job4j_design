package io.chat;

import java.io.*;
import java.util.Scanner;

public class Chat {
    public static void main(String[] args) {
        String start = "Start chat \n stop - for stop chat;\n go - for continuation chat";
        String question;
        String answer;
        boolean stop = true;
        Scanner scanner = new Scanner(System.in);
        try (PrintWriter writer = new PrintWriter(new BufferedOutputStream(
                new FileOutputStream("chatLog.txt")))) {
            System.out.println(start);
            writer.write(start + "\n");
            question = scanner.nextLine();
            while (!(question.equalsIgnoreCase("exit"))) {
                writer.write("Q:" + question + "\n");
                if (question.equals("stop")) {
                    stop = false;
                } else if (question.equals("go")) {
                    stop = true;
                }
                if ((stop) && !question.isEmpty()) {
                    answer = Answer.chatAnswer();
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