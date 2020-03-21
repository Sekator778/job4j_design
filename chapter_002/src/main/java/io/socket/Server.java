package io.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        int count = 0;
        while (true) {
            Socket clientSoket = serverSocket.accept();
            System.out.println("Client accepted " + (count++));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSoket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSoket.getInputStream()));

            String request = reader.readLine();
            String response = "#" + count + " , your message length is " + request.length();

            writer.write(response);
            writer.newLine();
            writer.flush();
            writer.close();
            reader.close();
            clientSoket.close();

        }
    }
}