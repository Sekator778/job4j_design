package io.server;

import java.io.*;

public class Analyze {
    public void unavailable(String source, String target) {
        boolean check = false;
        try (
                BufferedReader fileReader = new BufferedReader(new FileReader(source));
                PrintWriter fireWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))
        ) {
            while (fileReader.ready()) {
                String s = fileReader.readLine();
                var s1 = (s.split(" "));
                if (((s1[0].startsWith("400")) || (s1[0].startsWith("500"))) && !check) {
                    fireWriter.write(s1[1]);
                    fireWriter.write("\n");
                    check = true;
                } else if (((s1[0].startsWith("200")) || (s1[0].startsWith("300"))) && check) {
                    fireWriter.write(s1[1]);
                    fireWriter.write("\n");
                    check = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Analyze().unavailable("/home/sekator/projects/job4j_design/server.log", "target.txt");
    }
}