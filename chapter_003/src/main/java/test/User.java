package test;

import java.util.HashSet;

/**
 *
 */

public class User {
    String name;
    HashSet<String> mails;
    boolean isProcessed = false;

    public User(String name, HashSet<String> mails) {
        this.name = name;
        this.mails = mails;
    }

    public String getName() {
        return name;
    }

    public HashSet<String> getMails() {
        return mails;
    }
}