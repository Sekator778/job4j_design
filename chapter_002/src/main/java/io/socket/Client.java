package io.socket;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 8000);
        int count = 0;

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        writer.write("Get me some information");
        writer.newLine();
        writer.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String message = reader.readLine();
        System.out.println(message);

        reader.close();
        writer.close();
        clientSocket.close();
    }
}
