//package io.socket;
//
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class EchoServer {
//    public static void main(String[] args) throws IOException {
//        try (ServerSocket server = new ServerSocket(9000)) {
//            while (!server.isClosed()) {
//                Socket socket = server.accept();
//                try (OutputStream out = socket.getOutputStream();
//                     BufferedReader in = new BufferedReader(
//                             new InputStreamReader(socket.getInputStream()))) {
//                    String str;
//                    while (!(str = in.readLine()).isEmpty()) {
//                        if (str.contains("exit")) {
//                            out.write("Server close\n".getBytes());
//                            server.close();
//                        } else if (str.contains("hello")) {
//                            out.write("Hello, dear friend.\n".getBytes());
//                            break;
//                        } else {
//                            str = str.substring(str.indexOf("=") + 1);
//                            int x = str.indexOf("H");
//                            str = str.substring(0, x);
//                            out.write(str.getBytes());
//                            out.write("\r\n".getBytes());
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
