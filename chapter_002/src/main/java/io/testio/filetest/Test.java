package io.testio.filetest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) throws IOException {
        String data = new String(Files.readAllBytes(Paths.get("input.txt")));
        System.out.println(data);


    }
}
