package tree.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TreeApp {
    public static void main(String[] args) throws Exception {
        int value;
        Tree tree = new Tree();
        tree.insert(50, 15);
        tree.insert(25, 12);
        tree.insert(75, 17);
        tree.insert(12, 15);
        tree.insert(37, 12);
        tree.insert(43, 17);
        tree.insert(30, 15);
        tree.insert(33, 12);
        tree.insert(87, 17);
        tree.insert(93, 15);
        tree.insert(97, 15);

        boolean run = true;
        while (run) {
            System.out.println("Enter first letter of show, insert, find, delete or end:");

            int choice = getChar();
            switch (choice) {
                case 's':
                    System.out.println(tree.displayTree());
                    break;
                case 'i':
                    System.out.println("Enter value to insert: ");
                    value = getInt();
                    tree.insert(value, value + 9);
                    break;
                case 'f':
                    System.out.println("Enter value to find: ");
                    Node found = tree.find(getInt());
                    if (found != null) {
                        System.out.print("Found: ");
                        found.displayNode();
                        System.out.println();
                    }
                    break;
                case 'e':
                    run = false;
                    break;
                case 'd':
                    System.out.println("Enter value to delete: ");
                    value = getInt();
                    tree.delete(value);
                    break;
                default:
                    return;
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    // -------------------------------------------------------------
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    //-------------------------------------------------------------
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}