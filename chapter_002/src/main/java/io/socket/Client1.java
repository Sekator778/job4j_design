package io.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("127.0.0.1", 8080);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            String inputLine;

            out.println(1);
            System.out.println("have wrote to server: 1");

            while ((inputLine = in.readLine()) != null) {
                System.out.println("have a read from server: " + inputLine);
                int number = Integer.parseInt(inputLine);

                if (number >= 10) {
                    break;
                }
                number++;
                out.println(number);
                System.out.println("have wrote to server: " + number);
                Thread.sleep(1500);
            }
            System.out.println("disconnecting ...........");
        } catch (Throwable cause) {
            System.out.println("connection error " + cause.getMessage());
        }
    }
}
