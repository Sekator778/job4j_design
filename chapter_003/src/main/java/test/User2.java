package test;

import java.util.HashSet;
import java.util.Set;

public class User2 {
    String name;
    HashSet<String> mails;
    boolean isProcessed = false;

    public User2(String name, HashSet<String> mails) {
        this.name = name;
        this.mails = mails;
    }

    public String getName() {
        return name;
    }

    public Set<String> getMails() {
        return mails;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", mails=" + mails;
    }
}