package io;

import java.io.FileOutputStream;
import java.io.IOException;

public class MatrixToFile {
    public void multiple() {
        int size = 5;
        int[][] table = new int[size][size];
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table.length; j++) {
                    String rsl = (i + 1) * (j + 1) + " ";
                    out.write(rsl.getBytes());
                }
                out.write("\n".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
