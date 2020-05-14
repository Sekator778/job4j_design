package test;

import java.util.List;

/**
 * класс юзер для почты
 */

public class User {
    String name;
    List<String> mails;
    boolean isProcessed = false;

    public User(String name, List<String> mails) {
        this.name = name;
        this.mails = mails;
    }

    public String getName() {
        return name;
    }

    public List<String> getMails() {
        return mails;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", mails=" + mails;
    }
}