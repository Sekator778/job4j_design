package myio;

import java.io.FileInputStream;
import java.io.IOException;

public class ShowFile {
    public static void main(String[] args) {
        int i;
        System.out.println("ars length: " + args.length);
        //
        if (args.length != 1) {
            System.out.println(
                    "Use file: " + args[0]
            );
            return;
        }
//        11 Ниже оператор try с ресурсами применяется
//        11 сначала для открытия, а затем для автоматического
//        11 закрытия файла по завершении блока этого оператора
        try (FileInputStream fin = new FileInputStream(args[0])) {
            do {
                i = fin.read();
                if (i != -1) {
                    System.out.print((char) i);
                }
            }
            while (i != -1);
        } catch (IOException e) {
            System.out.println("Фaйл найден.");
            e.printStackTrace();
        }
    }
}
