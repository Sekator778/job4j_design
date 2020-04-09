package testforjava;

import java.util.Scanner;

/**
 *Реализовать программу калькулятор. Калькулятор должен выполнять операции:
 * сложение, вычитание, умножение, деление, возведение в степень. При выполнении деления ввести проверку на 0.
 *  Если второй аргумент 0 нужно выкинуть исключение java.lang.IllegalStateException
 */

public class One {
    private int sum(int one, int two) {
        return one + two;
    }

    private int sub(int one, int two) {
        return one - two;
    }

    private int div(int one, int two) {
        if (two == 0) {
            throw new IllegalStateException();
        }
        return one / two;
    }

    private int mult(int one, int two) {
        return one * two;
    }

    private int step(int one, int two) {
        return (int) Math.pow(one, two);
    }

    private int giveNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private String giveString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void check(int one, int two, String doit) {
        switch (doit) {
            case "+":
                System.out.println(sum(one, two));
                break;
            case "*":
                System.out.println(mult(one, two));
                break;
            case "-":
                System.out.println(sub(one, two));
                break;
            case "/":
                System.out.println(div(one, two));
                break;
            case "!":
                System.out.println(step(one, two));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + doit);
        }
    }

    public  void init() {
        System.out.println(" Я умею сложение, вычитание, умножение, деление, возведение в степень.");
        System.out.println("Введите 2 цифры и действие, степень !");
            int one = giveNumber();
            int two = giveNumber();
            String s = giveString();
            check(one, two, s);
    }

    public static void main(String[] args) {
        new One().init();
    }
}
