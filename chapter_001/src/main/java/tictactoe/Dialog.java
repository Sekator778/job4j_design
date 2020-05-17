package tictactoe;

import java.util.Scanner;

/**
 * вывод на экран и считывание с консоли
 */

public class Dialog {
    public Scanner scanner = new Scanner(System.in);

    public void writeMessage(String message) {
        System.out.println(message);
    }


    private String readString() {
        return scanner.nextLine();
    }

    public int readInt() {
        String string;
        int rsl;
        do {
            string = readString();
            if (isNumeric(string)) {
                rsl = Integer.parseInt(string);
                break;
            }
            System.out.println("invalid input. ONLY DIGITAL");
        } while (true);
        return rsl;
    }

    private boolean isNumeric(String strNum) {
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
}
