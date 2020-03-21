package io.chat;

import java.io.*;
import java.util.Scanner;

public class Chat {
    public static void main(String[] args) {
        String start = "Start chat \n stop - for stop chat;\n go - for continuation chat";
        String question;
        String answer;
        boolean startChat = true;
        Scanner scanner = new Scanner(System.in);
        try (PrintWriter writer = new PrintWriter(new BufferedOutputStream(
                new FileOutputStream("chatLog.txt")))) {
            System.out.println(start);
            writer.write(start + "\n");
            while (!((question = scanner.nextLine()).equalsIgnoreCase("exit"))) {
                writer.write("Q:" + question + "\n");

                if (question.equals("stop")) {
                    startChat = false;
                } else if (question.equals("go")) {
                    startChat = true;
                    continue;
                }
                if (startChat) {
                    answer = Answer.chatAnswer();
                    System.out.println(answer);
                    writer.write("A:" + answer + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
