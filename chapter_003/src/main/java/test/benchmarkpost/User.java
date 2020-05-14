package test.benchmarkpost;

import java.util.Set;

/**
 * user on List for mails
 */

public class User {
    String name;
    Set<String> mails;

    public User(String name, Set<String> mails) {
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