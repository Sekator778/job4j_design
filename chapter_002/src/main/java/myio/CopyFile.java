package myio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) {
        int i;
        // сначала убедиться, что
        if (args.length != 2) {
            //  заданы            оба
            System.out.println("Иcпoльзoвaниe: файла  CopyFile откуда " + args[0] + "куда " + args[1]);
            return;
        }
        // открыть два файла и управлять ими в операторе try
        try (FileInputStream fin = new FileInputStream(args[0]);
             FileOutputStream fout = new FileOutputStream(args[1])) {
            do {
                i = fin.read();
                if (i != -1) {
                    fout.write(i);
                    System.out.print((char) i);
                }
            }
            while (i != -1);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oшибкa ввода - вывода:");
        }
    }
}
